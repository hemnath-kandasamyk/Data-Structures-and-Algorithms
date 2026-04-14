// ─── Tango Solver — script.js ─────────────────────────────────

// DOM refs
const generateBtn  = document.getElementById("generate-btn");
const solveBtn     = document.getElementById("solve-btn");
const clearBtn     = document.getElementById("clear-btn");
const gridSizeInput = document.getElementById("grid-size");
const gridContainer = document.getElementById("grid-container");
const gridCard     = document.getElementById("grid-card");
const statusBar    = document.getElementById("status-bar");
const solveLabel   = document.getElementById("solve-label");
const spinner      = document.getElementById("spinner");

let currentSize = 0;

// ─── Generate Grid ────────────────────────────────────────────
generateBtn.addEventListener("click", () => {
  const n = parseInt(gridSizeInput.value, 10);

  if (isNaN(n) || n < 2 || n > 10) {
    showStatus("Grid size must be between 2 and 10.", "error");
    return;
  }

  currentSize = n;
  buildGrid(n);
  gridCard.classList.remove("hidden");
  hideStatus();

  setTimeout(() => gridCard.scrollIntoView({ behavior: "smooth", block: "start" }), 50);
});

// ─── Build Grid DOM ───────────────────────────────────────────
function buildGrid(n) {
  gridContainer.innerHTML = "";
  const table = document.createElement("table");
  table.id = "puzzle-grid";

  for (let r = 0; r < n; r++) {
    const tr = document.createElement("tr");
    for (let c = 0; c < n; c++) {
      const td = document.createElement("td");
      const input = document.createElement("input");
      input.type = "text";
      input.maxLength = 1;
      input.classList.add("cell");
      input.dataset.row = r;
      input.dataset.col = c;
      input.addEventListener("input", handleCellInput);
      input.addEventListener("keydown", handleCellNav);
      td.appendChild(input);
      tr.appendChild(td);
    }
    table.appendChild(tr);
  }
  gridContainer.appendChild(table);
}

function handleCellInput(e) {
  const input = e.target;
  let val = input.value.toUpperCase().trim();
  if (val !== "X" && val !== "O") val = "";
  input.value = val;
  updateCellStyle(input, val);
  input.classList.remove("solved-sun", "solved-moon");
}

function updateCellStyle(input, val) {
  input.classList.remove("sun", "moon");
  if (val === "X") input.classList.add("sun");
  else if (val === "O") input.classList.add("moon");
}

function handleCellNav(e) {
  const n = currentSize;
  const r = parseInt(e.target.dataset.row);
  const c = parseInt(e.target.dataset.col);
  const dirs = { ArrowRight: [r, c + 1], ArrowLeft: [r, c - 1], ArrowDown: [r + 1, c], ArrowUp: [r - 1, c] };
  if (dirs[e.key]) {
    e.preventDefault();
    const [nr, nc] = dirs[e.key];
    if (nr >= 0 && nr < n && nc >= 0 && nc < n) getCellInput(nr, nc).focus();
  }
}

function getCellInput(r, c) {
  return document.querySelector(`#puzzle-grid input[data-row="${r}"][data-col="${c}"]`);
}

clearBtn.addEventListener("click", () => {
  const cells = document.querySelectorAll("#puzzle-grid input.cell");
  cells.forEach(input => {
    input.value = "";
    input.className = "cell";
    input.disabled = false;
  });
  hideStatus();
});

function collectGrid() {
  const n = currentSize;
  const grid = [];
  for (let r = 0; r < n; r++) {
    const row = [];
    for (let c = 0; c < n; c++) {
      const val = getCellInput(r, c).value.toUpperCase().trim();
      row.push(val === "X" || val === "O" ? val : "");
    }
    grid.push(row);
  }
  return grid;
}

// ─── LOCAL SOLVER LOGIC (The "Backend" in JS) ─────────────────

function isValid(board, n, row, col, sym) {
  const maxSymbols = n / 2;

  // 1. Check Row Consecutive
  if (col >= 2 && board[row][col-1] === sym && board[row][col-2] === sym) return false;
  if (col >= 1 && col < n-1 && board[row][col-1] === sym && board[row][col+1] === sym) return false;
  if (col <= n-3 && board[row][col+1] === sym && board[row][col+2] === sym) return false;

  // 2. Check Column Consecutive
  if (row >= 2 && board[row-1][col] === sym && board[row-2][col] === sym) return false;
  if (row >= 1 && row < n-1 && board[row-1][col] === sym && board[row+1][col] === sym) return false;
  if (row <= n-3 && board[row+1][col] === sym && board[row+2][col] === sym) return false;

  // 3. Row Balance
  let rCount = 0;
  for (let c = 0; c < n; c++) if (board[row][c] === sym) rCount++;
  if (rCount >= maxSymbols) return false;

  // 4. Column Balance
  let cCount = 0;
  for (let r = 0; r < n; r++) if (board[r][col] === sym) cCount++;
  if (cCount >= maxSymbols) return false;

  return true;
}

function backtrack(board, n, row, col) {
  if (row === n) return true;

  let nextRow = (col === n - 1) ? row + 1 : row;
  let nextCol = (col === n - 1) ? 0 : col + 1;

  if (board[row][col] !== "") {
    return backtrack(board, n, nextRow, nextCol);
  }

  for (let sym of ["X", "O"]) {
    if (isValid(board, n, row, col, sym)) {
      board[row][col] = sym;
      if (backtrack(board, n, nextRow, nextCol)) return true;
      board[row][col] = ""; // Undo
    }
  }
  return false;
}

// ─── Modified Solve Button ────────────────────────────────────
solveBtn.addEventListener("click", () => {
  const grid = collectGrid();
  
  solveLabel.textContent = "Solving…";
  spinner.classList.remove("hidden");
  solveBtn.disabled = true;
  hideStatus();

  // Use a small timeout to let the UI update the spinner before the CPU works
  setTimeout(() => {
    try {
      // Create a deep copy of the grid for the solver
      const boardToSolve = JSON.parse(JSON.stringify(grid));
      const success = backtrack(boardToSolve, currentSize, 0, 0);

      if (!success) {
        throw new Error("No valid solution exists for this configuration.");
      }

      displaySolvedGrid(boardToSolve, grid);
      showStatus("✓ Puzzle solved successfully!", "success");

    } catch (err) {
      showStatus(`✗ ${err.message}`, "error");
    } finally {
      solveLabel.textContent = "Solve Puzzle";
      spinner.classList.add("hidden");
      solveBtn.disabled = false;
    }
  }, 50);
});

// ─── Display Solved Grid ──────────────────────────────────────
function displaySolvedGrid(solvedGrid, originalGrid) {
  const n = currentSize;
  for (let r = 0; r < n; r++) {
    for (let c = 0; c < n; c++) {
      const input = getCellInput(r, c);
      const val = solvedGrid[r][c];
      const wasEmpty = originalGrid[r][c] === "";

      input.value = val;
      input.disabled = true;
      input.className = "cell";

      if (wasEmpty) {
        input.classList.add(val === "X" ? "solved-sun" : "solved-moon");
        input.style.animationDelay = `${(r * n + c) * 18}ms`;
      } else {
        input.classList.add(val === "X" ? "sun" : "moon");
        input.classList.add("prefilled");
      }
    }
  }
}

function showStatus(msg, type) {
  statusBar.textContent = msg;
  statusBar.className = `status-bar ${type}`;
  statusBar.classList.remove("hidden");
  statusBar.scrollIntoView({ behavior: "smooth", block: "nearest" });
}

function hideStatus() {
  statusBar.classList.add("hidden");
  statusBar.className = "status-bar hidden";
}
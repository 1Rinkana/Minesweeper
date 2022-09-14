package minesweeper

fun mineAction(row: Int, cell: Int) {   // action is mine
    if (staticField[row][cell] != "X" && fieldForGame[row][cell] == "*") {
        fieldForGame[row][cell] = "."
    }
    else if (staticField[row][cell] == "X" && fieldForGame[row][cell] == "*") {
        fieldForGame[row][cell] = "."
        amountOfClosedMines++
    }
    else if (staticField[row][cell] == "X" && fieldForGame[row][cell] == ".") {
        fieldForGame[row][cell] = "*"
        amountOfClosedMines--
    }
    else if (staticField[row][cell] != "X" && fieldForGame[row][cell] == ".") {
        fieldForGame[row][cell] = "*"
        amountOfClosedMines++
    }
    playersField()
}

fun freeAction(row: Int, cell: Int) {  // action is free
    if (isDigit(staticField[row][cell])) {
        fieldForGame[row][cell] = staticField[row][cell]
        playersField()
    }
    if (staticField[row][cell] == ".") {
        fieldForGame[row][cell] = "/"
        cellDiscovery()
        playersField()
    }
}

fun cellDiscovery() {  // action is free
    for ((rowIndex, row) in staticField.withIndex()) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (fieldForGame[rowIndex][cellIndex] == "/") {
                doWhatIsPossible(rowIndex, cellIndex)
            }
        }
    }
    for ((rowIndex, row) in staticField.withIndex()) {
        for (cell in 8 downTo 0) {
            if (fieldForGame[rowIndex][cell] == "/") {
                doWhatIsPossible(rowIndex, cell)
            }
        }
    }
    for (row in 8 downTo 0) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (fieldForGame[row][cellIndex] == "/") {
                doWhatIsPossible(row, cellIndex)
            }
        }
    }
    for (row in 8 downTo 0) {
        for (cell in 8 downTo 0) {
            if (fieldForGame[row][cell] == "/") {
                doWhatIsPossible(row, cell)
            }
        }
    }
    for ((rowIndex, row) in staticField.withIndex()) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (fieldForGame[rowIndex][cellIndex] == "/") {
                doWhatIsPossible(rowIndex, cellIndex)
            }
        }
    }
    for ((rowIndex, row) in staticField.withIndex()) {
        for (cell in 8 downTo 0) {
            if (fieldForGame[rowIndex][cell] == "/") {
                doWhatIsPossible(rowIndex, cell)
            }
        }
    }
    for (row in 8 downTo 0) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (fieldForGame[row][cellIndex] == "/") {
                doWhatIsPossible(row, cellIndex)
            }
        }
    }
    for (row in 8 downTo 0) {
        for (cell in 8 downTo 0) {
            if (fieldForGame[row][cell] == "/") {
                doWhatIsPossible(row, cell)
            }
        }
    }
}

fun doWhatIsPossible(row: Int, cell: Int) {
    if (row == 0 && cell == 0) { // top left
        fieldForGame[row][cell + 1] = newValue(row, cell + 1)
        fieldForGame[row + 1][cell + 1] = newValue(row + 1, cell + 1)
        fieldForGame[row + 1][cell] = newValue(row + 1, cell)
    }
    else if (row == 0 && cell == fieldSize - 1) { // top right
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row + 1][cell - 1] = newValue(row + 1, cell - 1)
        fieldForGame[row + 1][cell] = newValue(row + 1, cell)
    }
    else if (row == fieldSize - 1 && cell == fieldSize - 1) { // down right
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row - 1][cell - 1] = newValue(row - 1, cell - 1)
        fieldForGame[row - 1][cell] = newValue(row - 1, cell)
    }
    else if (row == fieldSize - 1 && cell == 0) {
        fieldForGame[row - 1][cell] = newValue(row - 1, cell) // down left
        fieldForGame[row - 1][cell + 1] = newValue(row - 1, cell + 1)
        fieldForGame[row][cell + 1] = newValue(row, cell + 1)
    }
    else if (row == 0) { // up
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row + 1][cell - 1] = newValue(row + 1, cell - 1)
        fieldForGame[row + 1][cell] = newValue(row + 1, cell)
        fieldForGame[row + 1][cell + 1] = newValue(row + 1, cell + 1)
        fieldForGame[row][cell + 1] = newValue(row, cell + 1)
    }
    else if (row == fieldSize - 1) { // down
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row - 1][cell - 1] = newValue(row - 1, cell - 1)
        fieldForGame[row - 1][cell] = newValue(row - 1, cell)
        fieldForGame[row - 1][cell + 1] = newValue(row - 1, cell + 1)
        fieldForGame[row][cell + 1] = newValue(row, cell + 1)
    }
    else if (cell == 0) { // left
        fieldForGame[row - 1][cell] = newValue(row - 1, cell)
        fieldForGame[row - 1][cell + 1] = newValue(row - 1, cell + 1)
        fieldForGame[row][cell + 1] = newValue(row, cell + 1)
        fieldForGame[row + 1][cell + 1] = newValue(row + 1, cell + 1)
        fieldForGame[row + 1][cell] = newValue(row + 1, cell)
    }
    else if (cell == fieldSize - 1) { // right
        fieldForGame[row - 1][cell] = newValue(row - 1, cell)
        fieldForGame[row - 1][cell - 1] = newValue(row - 1, cell - 1)
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row + 1][cell - 1] = newValue(row + 1, cell - 1)
        fieldForGame[row + 1][cell] = newValue(row + 1, cell)
    }
    else { // other
        fieldForGame[row - 1][cell] = newValue(row - 1, cell)
        fieldForGame[row - 1][cell + 1] = newValue(row - 1, cell + 1)
        fieldForGame[row][cell + 1] = newValue(row, cell + 1)
        fieldForGame[row + 1][cell + 1] = newValue(row + 1, cell + 1)
        fieldForGame[row + 1][cell] = newValue(row + 1, cell)
        fieldForGame[row + 1][cell - 1] = newValue(row + 1, cell - 1)
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row - 1][cell - 1] = newValue(row - 1, cell - 1)
    }
}

fun newValue(row: Int, cell: Int): String {
    return if (fieldForGame[row][cell] == "*") {
        if (isDigit(staticField[row][cell])) staticField[row][cell] else "/"
    } else if (isDigit(staticField[row][cell])) {
        staticField[row][cell]
    } else if (staticField[row][cell] == ".") {
        "/"
    } else "1"
}

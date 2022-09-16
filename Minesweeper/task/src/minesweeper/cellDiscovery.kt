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
    repeat(2) {
        for (row in 0 until fieldSize) {
            for (cell in 0 until fieldSize) {
                if (fieldForGame[row][cell] == "/") {
                    doWhatIsPossible(row, cell)
                }
            }
        }
        for (row in 0 until fieldSize - 1) {
            for (cell in fieldSize - 1 downTo 0) {
                if (fieldForGame[row][cell] == "/") {
                    doWhatIsPossible(row, cell)
                }
            }
        }
        for (row in fieldSize - 1 downTo 0) {
            for (cell in 0 until fieldSize) {
                if (fieldForGame[row][cell] == "/") {
                    doWhatIsPossible(row, cell)
                }
            }
        }
        for (row in fieldSize - 1 downTo 0) {
            for (cell in fieldSize - 1 downTo 0) {
                if (fieldForGame[row][cell] == "/") {
                    doWhatIsPossible(row, cell)
                }
            }
        }
    }
}

fun doWhatIsPossible(row: Int, cell: Int) {
    if (row == 0 && cell == 0) { // top left
        fieldForGame[row][1] = newValue(row, 1)
        fieldForGame[1][1] = newValue(1, 1)
        fieldForGame[1][cell] = newValue(1, cell)
    }
    else if (row == 0 && cell == fieldSize - 1) { // top right
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[1][cell - 1] = newValue(1, cell - 1)
        fieldForGame[1][cell] = newValue(1, cell)
    }
    else if (row == fieldSize - 1 && cell == fieldSize - 1) { // down right
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[row - 1][cell - 1] = newValue(row - 1, cell - 1)
        fieldForGame[row - 1][cell] = newValue(row - 1, cell)
    }
    else if (row == fieldSize - 1 && cell == 0) {
        fieldForGame[row - 1][cell] = newValue(row - 1, cell) // down left
        fieldForGame[row - 1][1] = newValue(row - 1, 1)
        fieldForGame[row][1] = newValue(row, 1)
    }
    else if (row == 0) { // up
        fieldForGame[row][cell - 1] = newValue(row, cell - 1)
        fieldForGame[1][cell - 1] = newValue(1, cell - 1)
        fieldForGame[1][cell] = newValue(1, cell)
        fieldForGame[1][cell + 1] = newValue(1, cell + 1)
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
        fieldForGame[row - 1][1] = newValue(row - 1, 1)
        fieldForGame[row][1] = newValue(row, 1)
        fieldForGame[row + 1][1] = newValue(row + 1, 1)
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

package minesweeper

import kotlin.random.Random
const val fieldSize = 9
val field = MutableList(fieldSize) {
    MutableList(fieldSize) { "." }
}.toList()

val fieldForGame = MutableList(fieldSize) {
    MutableList(fieldSize) { "." }
}.toList()

lateinit var staticField: List<List<String>>

fun main() {
    game()
}
var amountOfClosedMines = 0

fun game() {
    val mines = readln().toInt()
    amountOfClosedMines = mines
    playersField()
    println("Set/unset mines marks or claim a cell as free:")
    val(firstCell, firstRow, firstAction) = readln().split(" ")
    createField(mines, firstCell.toInt() - 1, firstRow.toInt() - 1)
    staticField = field.toList().map { it.toList() }

    if (firstAction == "free") freeAction(firstRow.toInt() - 1, firstCell.toInt() - 1) else mineAction(firstRow.toInt() - 1, firstCell.toInt() - 1)

    while (amountOfClosedMines != 0) {
        println("Set/unset mines marks or claim a cell as free:")
        val(cell, row, action) = readln().split(" ")
        if (action == "mine") {
            mineAction(row.toInt() - 1, cell.toInt() - 1)
        } else {
            if (staticField[row.toInt() - 1][cell.toInt() - 1] == "X") {
                gameIsLost()
                playersField()
                println("You stepped on a mine and failed!")
                break
            } else freeAction(row.toInt() - 1, cell.toInt() - 1)
        }
        if (isItWin(mines)) {
            println("Congratulations! You found all the mines!")
            break
        }
    }
    println("Congratulations! You found all the mines!")
}

fun isItWin(mines: Int): Boolean {
    var ans = true
    var count = 0
    for ((rowIndex, row) in staticField.withIndex()) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (staticField[rowIndex][cellIndex] == "X"  && fieldForGame[rowIndex][cellIndex] != "." || fieldForGame[rowIndex][cellIndex] != "*") ans = false
        }
    }
    for ((rowIndex, row) in staticField.withIndex()) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (fieldForGame[rowIndex][cellIndex] == ".") count++
        }
    }
    if (count > mines) ans = false
    return ans
}

fun createField(m: Int, firstCell: Int, firstRow: Int) {
    var mines = m
    while (mines > 0) {
        val row = Random.nextInt(0, 9)
        val cell = Random.nextInt(0, 9)
        if (row == firstRow && cell == firstCell) continue //central пропсиать еще 8 вариантов
        if (row == firstRow - 1 && cell == firstCell) continue //north
        if (row == firstRow - 1 && cell == firstCell + 1) continue //north-east
        if (row == firstRow && cell == firstCell + 1) continue //east
        if (row == firstRow + 1 && cell == firstCell + 1) continue //south-east
        if (row == firstRow + 1 && cell == firstCell) continue //south
        if (row == firstRow + 1 && cell == firstCell - 1) continue //south-west
        if (row == firstRow && cell == firstCell - 1) continue //west
        if (row == firstRow - 1 && cell == firstCell - 1) continue //north-west
        if (field[row][cell] == "X") {
            continue
        } else {
            field[row][cell] = "X"
            helpInTheGame(row, cell)
            mines--
        }
    }
}

fun playersField() {
    var num = 1
    println(" │123456789│")
    println("—│—————————│")
    for (raw in fieldForGame) {
        println("$num│${raw.joinToString("")}│")
        num++
    }
    println("—│—————————│")
}

fun helpInTheGame(row: Int, cell: Int) {
    if(row == 0 && cell == 0) {
        topLeft()
    } else if (row == 0 && cell == fieldSize - 1) {
        topRight()
    } else if (row == fieldSize - 1 && cell == 0) {
        bottomLeft()
    } else if (row == fieldSize - 1 && cell == fieldSize - 1) {
        bottomRight()
    } else if (row == 0) {
        firstRow(cell)
    } else if (row == fieldSize - 1) {
        lastRow(cell)
    } else if (cell == 0) {
        leftRow(row)
    } else if (cell == fieldSize - 1) {
        rightRow(row)
    } else placedAnywhere(row, cell)
}

fun gameIsLost() {
    for ((rowIndex, row) in staticField.withIndex()) {
        for ((cellIndex, cell) in staticField.withIndex()) {
            if (staticField[rowIndex][cellIndex] == "X") fieldForGame[rowIndex][cellIndex] = "X"
        }
    }
}

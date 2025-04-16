package utilities

// Represent the game pieces
sealed class Piece {
    object X : Piece() {
        override fun toString() = "X"
    }
    object O : Piece() {
        override fun toString() = "O"
    }
    object Empty : Piece() {
        override fun toString() = " "
    }
}

// Immutable board state
data class Board(val cells: List<List<Piece>> = List(3) { List(3) { Piece.Empty } }) {
    fun display(): String =
        cells.joinToString("\n") { row ->
            row.joinToString("|", "|", "|")
        }

    // Pure function to make a move
    fun makeMove(row: Int, col: Int, piece: Piece): Board? =
        when {
            !isValidPosition(row, col) -> null
            !isEmptyAt(row, col) -> null
            else -> Board(cells.mapIndexed { r, rows ->
                rows.mapIndexed { c, cell ->
                    if (r == row && c == col) piece else cell
                }
            })
        }

    // Pure functions to check game state
    fun isEmptyAt(row: Int, col: Int): Boolean =
        cells[row][col] == Piece.Empty

    fun hasWinner(): Piece? {
        // Check rows
        cells.forEach { row ->
            row.distinct().singleOrNull()?.let { if (it != Piece.Empty) return it }
        }

        // Check columns
        (0..2).forEach { col ->
            val column = cells.map { it[col] }
            column.distinct().singleOrNull()?.let { if (it != Piece.Empty) return it }
        }

        // Check diagonals
        val diagonal1 = listOf(cells[0][0], cells[1][1], cells[2][2])
        val diagonal2 = listOf(cells[0][2], cells[1][1], cells[2][0])

        diagonal1.distinct().singleOrNull()?.let { if (it != Piece.Empty) return it }
        diagonal2.distinct().singleOrNull()?.let { if (it != Piece.Empty) return it }

        return null
    }

    fun isFull(): Boolean =
        cells.all { row -> row.all { it != Piece.Empty } }

    private fun isValidPosition(row: Int, col: Int): Boolean =
        row in 0..2 && col in 0..2
}

// Game state handler
data class GameState(
    val board: Board = Board(),
    val currentPlayer: Piece = Piece.X,
    val isGameOver: Boolean = false
)

// Pure function to process a turn
fun processTurn(state: GameState, row: Int, col: Int): GameState {
    if (state.isGameOver) return state

    val newBoard = state.board.makeMove(row, col, state.currentPlayer) ?: return state
    val winner = newBoard.hasWinner()
    val isGameOver = winner != null || newBoard.isFull()

    return GameState(
        board = newBoard,
        currentPlayer = if (state.currentPlayer == Piece.X) Piece.O else Piece.X,
        isGameOver = isGameOver
    )
}

fun main() {
    var gameState = GameState()

    println("Welcome to Tic-tac-toe!")
    println("Enter moves as 'row col' (0-2)")

    while (!gameState.isGameOver) {
        println("\n${gameState.board.display()}")
        println("\nPlayer ${gameState.currentPlayer}'s turn")

        print("Enter move: ")
        val input = readLine()?.split(" ")?.map { it.toIntOrNull() }

        if (input?.size == 2 && input.all { it != null }) {
            val (row, col) = input.filterNotNull()
            val newState = processTurn(gameState, row, col)

            if (newState != gameState) {
                gameState = newState

                if (gameState.isGameOver) {
                    println("\nFinal board:")
                    println(gameState.board.display())

                    val winner = gameState.board.hasWinner()
                    if (winner != null) {
                        println("\nPlayer $winner wins!")
                    } else {
                        println("\nIt's a draw!")
                    }
                }
            } else {
                println("Invalid move! Try again.")
            }
        } else {
            println("Invalid input! Please enter two numbers separated by space.")
        }
    }
}
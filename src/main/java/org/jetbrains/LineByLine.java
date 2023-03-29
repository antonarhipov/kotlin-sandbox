package org.jetbrains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//region ========= Agenda =========
// region 1. Setup & Navigation
//     - Themes
//     - View modes
//     - Recent Files
//     - Search everywhere
//     - Keymaps
//     - Folds
//     - Structure popup
// endregion
// region 2. Writing code
//  - Completions
//region BLah
//  - Live templates
//  - Refactorings
//  - Alt+Enter
//endregion
//  - Multiple cursors
// endregion
// region 3. Debugging
//  - Breakpoints in lambdas
//  - Run to cursor
//  - Step over lambdas
//  - Stream debugger (Trace Current Stream Chain)
//  - Evaluate expression
//  - Non-suspending breakpoints
//  - Evaluate and log
//  - Breakpoint bomb
// endregion
// region 4. Data flow analysis
//  - Analyze data flow to here
//  - Analyze data flow from here
// endregion
// region 5. Language injection
//   - HTML / Emmet
//   - SQL
// endregion
// region 6. Database support
//  - Inject language -> SQL -> Run in console
//endregion
//region 7. More
// region 7.1 Local history
//  - set a bookmark
// endregion
// region 7.1 Bookmarks
//  - set anonymous bookmark - F11
//  - mnemonic, Cmd+F11
//  - go to mnemonic, Cmd+Shift+F11, Ctrl+N
//  - bookmarks view, Cmd+2
//  - list bookmarks
// endregion
//endregion
// endregion

//endregion
public class LineByLine {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            long count = reader.lines().filter(LineByLine::isComment).count();
            System.out.println(count);
        }
    }

    public static boolean isComment(String line){
        return !line.isEmpty()
                && !line.startsWith("//")
                && !line.startsWith("/*")
                && !line.startsWith("*")
                && !line.startsWith("*/");
    }
}


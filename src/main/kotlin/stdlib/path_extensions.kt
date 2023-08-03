package stdlib

import java.nio.file.Path
import java.time.LocalDate
import kotlin.io.path.*

@OptIn(ExperimentalPathApi::class)
fun main() {
    val sourceRoot = getSourceRoot()
    val destinationRoot = Path.of("backup/${LocalDate.now()}")

    sourceRoot.copyToRecursively(
        destinationRoot.createParentDirectories(),
        followLinks = false,
//        overwrite = true,
        onError = { source, target, exception ->
            println("Failed to copy $source to $target: ${exception.localizedMessage}")
            OnErrorResult.SKIP_SUBTREE
        }
    )

//    sourceRoot.copyToRecursively(destinationRoot,
//        followLinks = false,
//        onError = { source, target, exception ->
//            println("Failed to copy $source to $target: ${exception.localizedMessage}")
//            exception.printStackTrace()
//            OnErrorResult.TERMINATE
//        })

}

private fun getSourceRoot(): Path = Path.of("sourceRoot")
private fun getDestinationRoot(): Path = Path.of("destinationRoot")

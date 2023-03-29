package stdlib

import java.nio.file.Path
import kotlin.io.path.*

@OptIn(ExperimentalPathApi::class)
fun main() {
    val sourceRoot = getSourceRoot()
    val destinationRoot = getDestinationRoot()

    sourceRoot.copyToRecursively(destinationRoot,
        followLinks = false,
//        overwrite = false,
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

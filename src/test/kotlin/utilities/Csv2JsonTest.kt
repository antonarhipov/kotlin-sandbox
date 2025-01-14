package utilities

import kotlin.test.Test
import kotlin.test.assertEquals

class Csv2JsonTest {
    @Test
    fun `test csv to json with quoted values`() {
        val csv = """
            id,text
            1,"Hello, World"
            2,London Goodbye
        """.trimIndent()
        
        val expected = """[{"id":"1","text":"Hello, World"},{"id":"2","text":"London Goodbye"}]"""
        assertEquals(expected, csvToJson(csv))
    }
    
    @Test
    fun `test csv to json with escaped quotes`() {
        val csv = """
            id,text
            1,"He said ""Hello"" to me"
            2,Simple text
        """.trimIndent()
        
        val expected = """[{"id":"1","text":"He said \"Hello\" to me"},{"id":"2","text":"Simple text"}]"""
        assertEquals(expected, csvToJson(csv))
    }
    
    @Test
    fun `test csv to json with multiple quoted fields`() {
        val csv = """
            name,address,note
            "John Doe","123, Main St","Regular customer"
            "Jane Smith","456, Oak Ave",VIP
        """.trimIndent()
        
        val expected = """[{"name":"John Doe","address":"123, Main St","note":"Regular customer"},{"name":"Jane Smith","address":"456, Oak Ave","note":"VIP"}]"""
        assertEquals(expected, csvToJson(csv))
    }
}
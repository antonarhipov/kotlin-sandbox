data class D(var x: Int, var y: Int)
object Blah {
    fun t(p: D, q: D, r: D): Int {
        val v = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (v == 0) return 0
        return if (v > 0) 1 else 2
    }

    fun sss(dts: List<D>, n: Int) {
        if (n < 3) return
        val ds: MutableList<D> = ArrayList()
        var l = 0
        l = findMinIndex(n, dts, l)
        var p = l
        var q: Int
        do {
            ds += dts[p]
            q = (p + 1) % n
            for (i in 0 until n) {
                if (t(dts[p], dts[i], dts[q]) == 2) q = i
            }
            p = q
        } while (p != l)
        for (temp in ds) println("(" + temp.x + ", " + temp.y + ")")
    }

    private fun findMinIndex(n: Int, dts: List<D>, l: Int): Int {
        var l1 = l
        (1 until n).forEach { i ->
            if (dts[i].x < dts[l1].x) l1 = i
        }
        return l1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val ds = listOf(
            D(0, 3),
            D(2, 3),
            D(1, 1),
            D(2, 1),
            D(3, 0),
            D(0, 0),
            D(3, 3),
        )
        val n = ds.size
        sss(ds, n)
    }
}
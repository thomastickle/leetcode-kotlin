package leetcode.p0901

/**
 * # 901. Online Stock Span
 *
 * Design an algorithm that collects daily price quotes for a stock and returns the span of the
 * stock's price for the current day.
 *
 * The span of the stock's price in one day is the maximum number of consecutive days, starting
 * from that day and going backward, for which the stock price was less than or equal to that day's
 * price.
 *
 * For example, if the stock prices over seven days are `[100,80,60,70,60,75,85]`, the spans are
 * `[1,1,1,2,1,4,6]`.
 *
 * Implement the `StockSpanner` class:
 * - `StockSpanner()` initializes the object.
 * - `int next(int price)` returns the span of the stock's price for the current day, where today's
 *   price is `price`.
 *
 * Examples:
 * - Input operations: `["StockSpanner","next","next","next","next","next","next","next"]`
 * - Arguments: `[[],[100],[80],[60],[70],[60],[75],[85]]`
 * - Output: `[null,1,1,1,2,1,4,6]`
 * - Explanation:
 *   ```
 *   StockSpanner stockSpanner = new StockSpanner();
 *   stockSpanner.next(100); // returns 1
 *   stockSpanner.next(80);  // returns 1
 *   stockSpanner.next(60);  // returns 1
 *   stockSpanner.next(70);  // returns 2
 *   stockSpanner.next(60);  // returns 1
 *   stockSpanner.next(75);  // returns 4, because the last 4 prices, including today's price,
 *                           // were less than or equal to today's price
 *   stockSpanner.next(85);  // returns 6
 *   ```
 *
 * In another illustration, if the prices during the last four days are `[7,2,1,2]` and today's
 * price is `2`, today's span is `3`. If the prices during the last four days are `[7,34,1,2]` and
 * today's price is `8`, today's span is `3`.
 *
 * Constraints:
 * - `1 <= price <= 10^5`
 * - At most `10^4` calls will be made to `next`.
 *
 * [LeetCode 901: Online Stock Span](https://leetcode.com/problems/online-stock-span/)
 */
class StockSpanner {
    private data class PriceEntry(val price: Int, var day: Int = 1)

    private val priceStack = ArrayDeque<PriceEntry>()

    fun next(price: Int): Int {
        val priceEntry = PriceEntry(price, 1)

        while (priceStack.isNotEmpty() && price >= priceStack.last().price) {
            priceEntry.day += priceStack.removeLast().day
        }

        priceStack.add(priceEntry)

        return priceEntry.day
    }
}

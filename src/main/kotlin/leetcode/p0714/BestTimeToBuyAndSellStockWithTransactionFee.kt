package leetcode.p0714

/**
 * # 714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 * You are given an integer array `prices`, where `prices[i]` is the price of a stock on the ith
 * day, and an integer `fee` representing a transaction fee.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but
 * you must pay the transaction fee for each transaction. You may not engage in multiple
 * transactions simultaneously; you must sell the stock before buying again. The transaction fee
 * is charged only once for each stock purchase and sale.
 *
 * Examples:
 * - Input: `prices = [1, 3, 2, 8, 4, 9]`, `fee = 2`. Output: `8`. Explanation: Buy at `prices[0] = 1`,
 *   sell at `prices[3] = 8`, buy at `prices[4] = 4`, and sell at `prices[5] = 9`. The total profit
 *   is `((8 - 1) - 2) + ((9 - 4) - 2) = 8`.
 * - Input: `prices = [1, 3, 7, 5, 10, 3]`, `fee = 3`. Output: `6`.
 *
 * Constraints:
 * - `1 <= prices.length <= 5 * 10^4`.
 * - `1 <= prices[i] < 5 * 10^4`.
 * - `0 <= fee < 5 * 10^4`.
 *
 * [LeetCode 714: Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
 */
class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var hold = -prices[0]
        var cash = 0

        for (i in 1 until prices.size) {
            val oldHold = hold
            hold = maxOf(hold, cash - prices[i])
            cash = maxOf(cash, oldHold + prices[i] - fee)
        }

        return cash
    }
}

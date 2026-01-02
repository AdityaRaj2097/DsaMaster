class Solution {
    public int maxProfit(int[] prices) {
        int profit =0, buyPrice=prices[0];
        for(int i=1; i<prices.length; i++){
            if(prices[i]>buyPrice){
                profit += (prices[i]-buyPrice);
            }
            buyPrice = prices[i];
        }
        return profit;        
    }
    public int maxProfit2(int[] prices) {
    if (prices == null || prices.length == 0) return 0;

    int i = 0, n = prices.length;
    int profit = 0;

    while (i < n - 1) {
        // find valley (buy point)
        while (i < n - 1 && prices[i] >= prices[i + 1]) {
            i++;
        }
        int buy = prices[i];

        // find peak (sell point)
        while (i < n - 1 && prices[i] <= prices[i + 1]) {
            i++;
        }
        int sell = prices[i];

        profit += sell - buy;
    }

    return profit;
}
    public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;

    int bd = 0;   // buy day index
    int sd = 0;   // sell day index
    int prof = 0;

    for (int i = 1; i < prices.length; i++) {
        if (prices[i] >= prices[i - 1]) {
            sd++;
        } else {
            prof += prices[sd] - prices[bd];
            bd = sd = i;
        }
    }

    prof += prices[sd] - prices[bd];

    return prof;
}


}

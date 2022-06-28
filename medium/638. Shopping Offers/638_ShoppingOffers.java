class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int offerIndex, int amount) {
         int size = needs.size();
         if (offerIndex == special.size()){
             return amount + calculateAmount(needs, price);
         }
         List<Integer> updateNeeds = new ArrayList<>();
         for (int index = 0; index < size; index++) {
            if (special.get(offerIndex).get(index) <= needs.get(index)) {
                updateNeeds.add(needs.get(index) - special.get(offerIndex).get(index));
            } else {
                updateNeeds = null;
                break;
            }
         }
         int result = Integer.MAX_VALUE;
         if (updateNeeds != null) {
            result = amount + special.get(offerIndex).get(size) + calculateAmount(updateNeeds, price);
            int resultOne = shoppingOffers(price, special, updateNeeds, offerIndex, amount+special.get(offerIndex).get(size));
            int resultTwo = shoppingOffers(price, special, updateNeeds, offerIndex+1, amount+special.get(offerIndex).get(size));
            result = Math.min(result, Math.min(resultOne, resultTwo));
         }      
         result = Math.min(result, shoppingOffers(price, special, needs, offerIndex+1, amount));
         return result;
    }

    public int calculateAmount(List<Integer> needs, List<Integer> price){
        int result = 0;
        for (int i = 0; i < needs.size(); i++) {
            result += needs.get(i) * price.get(i);
        }
        return result;
    }

}
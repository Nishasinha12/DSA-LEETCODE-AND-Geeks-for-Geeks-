class Solution {
    public List<List<Integer>> generate(int numRows) {
        //result list of hold all rows
        List<List<Integer>> triangle=new ArrayList<>();
        for(int i=0;i<numRows;i++){

            List<Integer> rows= new ArrayList<>(Collections.nCopies(i+1, 1));

            for(int j=1;j<i;j++){
                rows.set(j ,
                    triangle.get(i-1).get(j-1) +
                    triangle.get(i-1).get(j)
                );
            }
            triangle.add(rows);
        }
        return triangle;
    }
}
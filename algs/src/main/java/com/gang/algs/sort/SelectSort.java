package com.gang.algs.sort;

public class SelectSort {

    public void sort(Comparable[] args){
        if(args == null || args.length <=0 ){
            return;
        }

        for(int i = 0; i<args.length; i++){
            for(int j=i+1; j<args.length; j++){
                if(less(args[i],args[j])){
                    exChange(args, i, j);
                }
            }
        }
    }

    private boolean less(Comparable arg1, Comparable arg2){
        if(arg1.compareTo(arg2) < 0){
            return true;
        }
        return false;
    }

    private void exChange(Comparable[] args, int i, int j){
        Comparable temp = args[i];
        args[i] = args[j];
        args[j] = temp;
    }

    public static void main(String[] args){
        SelectSort selectSort = new SelectSort();
        String[] sortArgs = {"1","3", "2"};
        selectSort.sort(sortArgs);

        for(String str : sortArgs){
            System.out.print(str+" ");
        }
    }

}

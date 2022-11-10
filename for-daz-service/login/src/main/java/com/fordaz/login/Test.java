package com.fordaz.login;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Test {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for(int i = 0; i < nums.length-1; i++){
                for(int k = i+1; k < nums.length; k++){
                    if(nums[i] + nums[k] == target){
                        return new int[]{i, k};
                    }
                }
            }
            return new int[]{0, 0};
        }

        public boolean isPalindrome(int x) {
            String inputToString = String.valueOf(x);
            int strLen = inputToString.length();
            for(int i = 0; i < strLen / 2; i ++){
                if(inputToString.charAt(i) != inputToString.charAt(strLen - i - 1)){
                    return false;
                }
            }
            return true;
        }

        class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            BigInteger bl1 = nodeToBigInteger(l1);
            BigInteger bl2 = nodeToBigInteger(l2);
        
            bl1.add(bl2);

            return BigIntegerToNode(bl1);
        }

        public ListNode BigIntegerToNode(BigInteger bi){
            int conv = bi.mod(new BigInteger("10")).intValue();
            ListNode result = new ListNode(conv);
            
            ListNode current = result;
            while(bi.bitLength() > 0){
                conv = bi.mod(new BigInteger("10")).intValue();
                ListNode node = new ListNode(conv);
                current.next = node;
                current = node;
                bi = bi.divide(new BigInteger("10"));
            }
            
            return result;
        }

        public BigInteger nodeToBigInteger(ListNode node){
            BigInteger sum = new BigInteger("0");
            BigInteger digit = new BigInteger("1");
            ListNode currentNode = node;
            while(currentNode != null){
                sum.add(BigInteger.valueOf(currentNode.val).multiply(digit));
                digit.multiply(new BigInteger("10"));
                currentNode = currentNode.next;
            }
            return sum;
        }

        public int myAtoi(String s) {
            s = lTrim(s);
            s = getOnlyNum(s);
            BigInteger result = new BigInteger(s);
            
            return getCamparedValue(result);
        }

        public String lTrim(String s){
            return s.replaceAll("^\\s+", "");
        }

        public String getOnlyNum(String s){
            int pointer = 0;

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '+' || c == '-' || (c >= '0' && '9' >= c)){
                    pointer = i;
                    
                    if(i > 0 && (s.charAt(i) == '+' || s.charAt(i) == '0')){
                        pointer--;
                    }
                }
            }
            for(int i = pointer + 1; i < s.length(); i++){
                if(!(s.charAt(i) >= '0' && '9' >= s.charAt(i))){
                    return s.substring(0, i);
                }
            }

            return s;
        }

        public int getCamparedValue(BigInteger bigInt){
            if(bigInt.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0){
                return Integer.MAX_VALUE;
            }

            if(bigInt.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0){
                return Integer.MIN_VALUE;
            }

            return bigInt.intValue();
        }
    }
}

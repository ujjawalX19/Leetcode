class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0, j = 0;
        int n = n1 + n2;

        int ind2 = n / 2;
        int ind1 = ind2 - 1;

        int count = 0;
        int ind1Ele = -1;
        int ind2Ele = -1;

        while (i < n1 && j < n2) {

            if (nums1[i] < nums2[j]) {

                if (count == ind1)
                    ind1Ele = nums1[i];

                if (count == ind2)
                    ind2Ele = nums1[i];

                count++;
                i++;

            } else {

                if (count == ind1)
                    ind1Ele = nums2[j];

                if (count == ind2)
                    ind2Ele = nums2[j];

                count++;
                j++;
            }
        }

        while (i < n1) {

            if (count == ind1)
                ind1Ele = nums1[i];

            if (count == ind2)
                ind2Ele = nums1[i];

            count++;
            i++;
        }

        while (j < n2) {

            if (count == ind1)
                ind1Ele = nums2[j];

            if (count == ind2)
                ind2Ele = nums2[j];

            count++;
            j++;
        }

        if (n % 2 == 1)
            return ind2Ele;

        return (ind1Ele + ind2Ele) / 2.0;
    }
}
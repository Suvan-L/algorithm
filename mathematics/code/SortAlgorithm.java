package sort;

import java.util.Arrays;

/**
 * 排序算法整理
 *      - [?] 冒泡排序
 *              - 5 种写法
 *              - 排序优化（添加标志位）
 *      - [?] 选择排序
 *              - 1 种写法
 *              - 排序优化（双游标移动）
 *      - [?] 插入排序
 *              - 2 种写法
 *              - 二分插入排序
 *              - 希尔插入排序
 *      - [?] 快速排序
 *      - [?] 归并排序
 *      - [?] 堆排序
 *
 * 创建日期：2018.03.01
 * 最后更新：2018.03.05
 *
 * @author Suvan
 */
public class SortAlgorithm {

    /**
     * 主函数
     */
    public static void main(String [] args) {
        SortAlgorithm sa = new SortAlgorithm();

        int[] arr = {192, 8, 64, 73, 92, 210, 2, 64, 85, 79, 21};

        //冒泡排序
        //sa.bubbleSort(arr);
        //sa.bubbleSortOptimization(arr);

        //选择排序
        //sa.selectSort(arr);
        //sa.selectSortOptimization(arr);

        //插入排序
        //sa.insertSort(arr);
        //sa.binaryInsertSort(arr);

        //希尔排序
        //sa.shellInsertSort(arr);

        //快速排序
        //sa.quickSort(arr, 0, arr.length - 1);
        //sa.quickSortOptimization(arr, 0, arr.length - 1);
        //System.out.println(Arrays.toString(arr));

        //归并排序
        //int [] result = new int[arr.length];
        //sa.mergeSortByRecursive(arr, result, 0, arr.length - 1);
        //sa.mergeSortByForeach(arr);
        //System.out.println(Arrays.toString(arr));

        //堆排序
        sa.heapSort(arr);
    }


    /*
     * ***********************************************
     * 私有函数
     * ***********************************************
     */

    /**
     * 交换函数
     *
     * @param arr 整型数组
     * @param aIndex a 数组下标
     * @param bIndex b 数组下标
     */
    private void swap(int[] arr, int aIndex, int bIndex) {
        arr[aIndex] ^= arr[bIndex];
        arr[bIndex] ^= arr[aIndex];
        arr[aIndex] ^= arr[bIndex];
    }

    /**
     * 检测不能为空
     *
     * @param arr 整型数组
     */
    private void checkNotNull(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("array is null!");
        }
    }


    /*
     * ***********************************************
     * 冒泡排序
     *      - 平均时间复杂度 O(n^2)
     * ***********************************************
     */

    /**
     * 冒牌排序
     *      - method 1: 倒序冒泡
     *      - method 2; 顺序冒泡
     *      - method 3: 倒序冒泡，位运算交换元素
     *      - method 4: 顺序冒牌，加减法交换元素
     *      - method 5: 倒序冒泡，乘除法交换元素
     *
     * @param arr 整型数组
     */
     private void bubbleSort(int [] arr) {
         this.checkNotNull(arr);
         if (arr.length == 0 || arr.length == 1) {
             return;
         }

         //method 1
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = len - 1; j > i; j --) {
         //        if(arr[j - 1] > arr[j]) {
         //            int tmp = arr[j];
         //            arr[j] = arr[j - 1];
         //            arr[j - 1] = tmp;
         //        }
         //    }
         //}

         //method 2
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = i; j < len - 1 - i; j ++) {
         //        if (arr[j] > arr[j + 1]) {
         //            int tmp = arr[j];
         //            arr[j] = arr[j + 1];
         //            arr[j + 1] = tmp;
         //        }
         //    }
         //}

         //method 3
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = len - 1; j > i; j --) {
         //        if (arr[j - 1] > arr[j]) {
         //            arr[j] ^= arr[j - 1];
         //            arr[j - 1] ^= arr[j];
         //            arr[j] ^= arr[j - 1];
         //        }
         //    }
         //}

         //method 4
         //for (int i = 0, len = arr.length; i < len - 1; i ++) {
         //    for (int j = 0; j < len - 1 - i; j ++) {
         //        if (arr[j] > arr[j + 1]) {
         //            arr[j] = arr[j] + arr[j + 1];
         //            arr[j + 1] = arr[j] - arr[j + 1];
         //            arr[j] = arr[j] - arr[j + 1];
         //        }
         //    }
         //}

         //method 5
         for (int i = 0, len = arr.length; i < len - 1; i ++) {
             for (int j = len - 1; j > i; j --) {
                 if (arr[j - 1] > arr[j]) {
                     arr[j] *= arr[j - 1];
                     arr[j - 1] = arr[j] / arr[j - 1];
                     arr[j] = arr[j] / arr[j - 1];
                 }
             }
         }

         System.out.println(Arrays.toString(arr));
     }

     /**
      * 冒泡排序优化
      *     - 加入标识位，若某次遍历数组未发生交换，则表示已排序成功，退出外循环
      *
      * @param arr 整形数组
      */
     private void bubbleSortOptimization(int [] arr) {
         this.checkNotNull(arr);
         if (arr.length == 0 || arr.length == 1) {
             return;
         }

         int len = arr.length;
         boolean flag = true;
         for (int i = 0; i < len - 1 && flag; i ++) {
             flag = false;

             for (int j = len - 1; j > i; j --) {
                 if (arr[j - 1] > arr[j]) {
                     arr[j] ^= arr[j - 1];
                     arr[j - 1] ^= arr[j];
                     arr[j] ^= arr[j - 1];
                     flag = true;
                 }
             }
         }

         System.out.println(Arrays.toString(arr));
     }


     /*
      * ***********************************************
      * 选择排序
      *     - 平均时间复杂度 O(n^2)
      * ***********************************************
      */

    /**
     * 选择排序
     *      - 每次选择最小的，放在数组起始位置（交换元素）
     *
     * @param arr 整型数组
     */
    private void selectSort(int [] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int min, minIndex;
        for (int i = 0, len = arr.length; i < len - 1; i ++) {
            min = arr[i];
             minIndex = i;
            for (int j = i + 1; j < len; j ++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

        System.out.println(Arrays.toString(arr));
     }

    /**
     * 选择排序优化
     *      - 每次遍历寻找最大值和最小值
     *          - 双游标（前后指针）
     *          - 每次遍历记录最小值 index 和最大值 index
     *
     * @param arr 整型数组
     */
    private void selectSortOptimization(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int minIndex, maxIndex;
        int firstPointer = 0, lastPointer = arr.length - 1;

        while (firstPointer < lastPointer) {
            minIndex = firstPointer;
            maxIndex = lastPointer;

            for (int i = firstPointer; i <= lastPointer; i ++) {
                if(arr[i] < arr[minIndex]) {
                    minIndex = i;
                } else if (arr[maxIndex] < arr[i]) {
                    maxIndex = i;
                }
            }

            if (minIndex != firstPointer) {
                swap(arr, firstPointer, minIndex);
            }
            if (maxIndex != lastPointer) {
                swap(arr, lastPointer, maxIndex);
            }

            firstPointer ++;
            lastPointer --;
        }

        System.out.println(Arrays.toString(arr));
    }


    /*
     * ***********************************************
     * 插入排序
     *      - 平均时间复杂度为O（n^2）
     * ***********************************************
     */

    /**
     * 插入排序
     *      - 从第 2 个元素开始遍历，循环点左边元素都是已排好序
     *      - 循环点的元素存入临时变量 tmp
     *      - 循环点前面的元素进行比较，若大于 tmp（循环点元素），则向后移动，且指针 j 前移
     *      - 满足结束条件，指针 + 1 位置赋值 tmp
     *
     *      //method 1: for + while （效率会更高些，将变量赋值尽可能移出内循环）
     *      //method 2: for + for
     *
     * @param arr 整型数组
     */
    private void insertSort(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        //method 1
        //int tmp, j;
        //for (int i = 1, len = arr.length; i < len; i ++) {
        //    tmp = arr[i];
        //
        //    j = i - 1;
        //    while (j >= 0 && arr[j] > tmp) {
        //        arr[j + 1] = arr[j];
        //        j --;
        //    }
        //
        //    arr[j + 1] = tmp;
        //}

        //method 2
        for (int i = 1, len = arr.length; i < len; i ++) {
            int tmp = arr[i];
            int pointer = i - 1;

            for (int j = i - 1; j >= 0; j --) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                    pointer --;
                } else {
                    break;
                }
            }

            if (pointer < i - 1) {
                arr[pointer + 1] = tmp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    /**
     * 二分插入排序
     *      - 对已排序的部分进行二分查找
     *
     * @param arr 整型数组
     */
    private void binaryInsertSort(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int tmp;
        int start, mid, end;
        int j;
        for (int i = 1, len = arr.length; i < len; i ++) {
            tmp = arr[i];

            //find
            start = 0;
            end = i - 1;
            while (start <= end) {
                mid = (start + end) / 2;

                if (arr[mid] <= tmp) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            //move
            for (j = i - 1; j >= start; j --) {
                arr[j + 1] = arr[j];
            }

            //while() finished, now start = end + 1
            arr[start] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔插入排序
     *      - 不稳定的排序算法
     *
     * @param arr 整型数组
     */
    private void shellInsertSort(int[] arr) {
        this.checkNotNull(arr);
        if (arr.length == 0 || arr.length == 1) {
            return;
        }

        int gap = 1;
        int len = arr.length;
        int i, j;
        int temp;

        //set init gap capacity (: 1, 4, 13, 40, 121, ...)
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }

        //narrow down for-each, gap ----> / 3
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i ++) {
                temp = arr[i];

                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }

                arr[j + gap] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /*
     * ***********************************************
     * 快速排序 method
     * ***********************************************
     */

    /**
     * 快速排序
     *      - 最好的情况 O(n log n)，最坏的情况 O(n^2)
     *      - 主要是分治法，一个序列分成两个序列
     *          1. 找基准
     *          2. 分区操作（小的放置基准前，大的放置基准后）
     *          3. 递归把小于基准值得 ‘子数列’ 和大于基准值元素的 ‘子数列’ 排序
     *
     * @param arr 整型数组
     * @param head 头指针（左）
     * @param tail 尾指针（右）
     */
    private void quickSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }

        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i ++;
            }

            while (arr[j] > pivot) {
                j --;
            }

            if (i < j) {
                this.swap(arr, i, j);

                i ++;
                j --;
            } else if (i == j) {
                i ++;
            }
        }

        this.quickSort(arr, 0, j);
        this.quickSort(arr, i, tail);
    }

    /**
     * 快排优化
     *   - 原地（in-place）分区的版本
     *   - 平均可以达到 O(\log n) 空间的使用复杂度
     *   - 递归到最后，数列长度为 1 | 0，表示已经排序完毕
     *
     * @param arr 振
     * @param head 头指针（左）
     * @param tail 尾指针（右）
     */
    private void quickSortOptimization(int[] arr, int head, int tail) {
        if (head < tail) {
            int pivot = (head + tail) / 2 + 1;
            int pivotIndex = this.partition(arr, head, tail, pivot);
            this.quickSort(arr, head, pivotIndex - 1);
            this.quickSort(arr, pivotIndex + 1, tail);
        }
    }

    /**
     * 原地分区算法
     *      - 用于快速排序优化
     *      - 它分区了标示为"左边（left）"和"右边（right）"的序列部分，
     *         借由移动小于a[pivotIndex]的所有元素到子序列的开头，留下所有大于或等于的元素接在他们后面。
     *      - 思路
     *          1. 储存中间值，然后中间值交换到末尾
     *          2. 定义临时指针（初始值为头指针）， 遍历 head -> right - 1，若小于中间值的数，交换到头指针，且自增
     *          3. 遍历结束，将会小于中间值的在数组前端（无序），大的接在后面（无序），最后是中间值
     *          4. 临时指针（无序的第一个大的），和末尾值交换，得到：临时指针-中间值
     *          5. 返回中间值的指针
     *      - 【注意】一个元素在到达它的最后位置前，可能会被交换很多次
     *
     * @param arr 数组
     * @param left 左指针
     * @param right 右指针
     * @param pivotIndex 中指针（中间值）
     * @return int 临时指针
     */
    private int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];

        //pivot move to last
        this.swap(arr, pivotIndex, right);

        int tmpIndex = left;
        for (int i = left; i < right - 1; i ++) {
            if (arr[i] <= pivotValue) {
                this.swap(arr, tmpIndex, i);
                tmpIndex ++;
            }
        }

        //pivot move to it last
        this.swap(arr, right, tmpIndex);
        return tmpIndex;
    }

    /*
     * ***********************************************
     * 归并排序
     *      - 归并操作（将两个已排序的序列合成一个序列的操作）
     *      - 迭代法
     *      - 递归法
     * ***********************************************
     */

    /**
     * 归并排序（递归版）
     *      - 效率为 O(n log n)
     *
     * @param arr 整型数组
     * @param result 结果数组（新申请空间, 数组长度与 arr 相等）
     * @param start 前指针
     * @param end 后指针
     */
    private void mergeSortByRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }

        int len = end - start, mid = (len >> 2) + start;
        int head1 = start, tail1 = mid;
        int head2 = mid + 1, tail2 = end;
        this.mergeSortByRecursive(arr, result, head1, tail1);
        this.mergeSortByRecursive(arr, result, head2, tail2);

        int k = start;
        while (head1 <= tail1 && head2 <= tail2) {
            result[k++] = arr[head1] < arr[head2] ? arr[head1++] : arr[head2++];
        }

        while (head1 <= tail1) {
            result[k++] = arr[head1++];
        }

        while (head2 <= tail2) {
            result[k++] = arr[head2++];
        }

        //filling
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }


    /**
     * 归并排序（迭代法）
     *
     * @param arr 整型数组
     */
    private void mergeSortByForeach(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }

        int len = arr.length;
        int [] result = new int[len];
        int block, start;
        int low, mid, high;
        int head1, tail1;
        int head2, tail2;
        int [] tmp;

        for (block = 1; block < len; block *= 2) {
            for (start = 0; start < len; start += 2 * block) {
                low = start;
                mid = (start + block) < len ? (start + block) : len;
                high = (start + 2 * block) < len ? (start + 2 * block) : len;

                head1 = low; tail1 = mid;
                head2 = mid; tail2 = high;

                //two block to merge sort
                while (head1 < tail1 && head2 < tail2) {
                    result[low ++] = arr[head1] < arr[head2] ? arr[head1 ++] : arr[head2 ++];
                }

                while (head1 < tail1) {
                    result[low ++] = arr[head1 ++];
                }

                while (head2 < tail2) {
                    result[low ++] = arr[head2 ++];
                }
            }

            tmp = result;
            result = arr;
            arr = tmp;
        }

        result = arr;
    }

    /*
     * ***********************************************
     * 堆排序
     *      - 利用堆这种数据结构设计的一种排序算法
     *      - 堆积是一种近似 '完全二叉树' 的结构
     *          - 同时满足堆积的性质： 子结点的键值 | 索引总是小于（or 大于） 它的父节点
     * ***********************************************
     */

    /**
     * 堆排序
     *      - 平均时间复杂度：O(n log n)
     *      - 步骤
     *          1. 数组堆化
     *          2. 对堆化数据排序
     *
     * @param arr 整型数组
     */
    private void heapSort(int [] arr) {
        //array -> heap
        int len = arr.length - 1;
        int beginIndex = (len - 1) / 2;
        for (int i = beginIndex; i >= 0; i --) {
            this.maxHeap(arr, i, len);
        }

        //sort -> heap type 'array'
        for (int i = len; i > 0; i --) {
            this.swap(arr, 0, i);
            this.maxHeap(arr, 0, i - 1);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 最大堆递归
     *      - 调整索引为 index 处的数据，使其符合堆的特性
     *
     * @param arr 整型数组
     * @param index 需要堆化处理数据的索引
     * @param len 未排序的堆（数组）的长度
     */
    private void maxHeap(int [] arr, int index, int len) {
        int leftIndex = (index * 2) + 1;
        int rightIndex = leftIndex + 1;
        int childMaxIndex = leftIndex;

        if (leftIndex > len) {
            return;
        }

        if (rightIndex <= len && arr[leftIndex] < arr[rightIndex]) {
            childMaxIndex = rightIndex;
        }

        if (arr[childMaxIndex] > arr[index]) {
            this.swap(arr, childMaxIndex, index);
            this.maxHeap(arr, childMaxIndex, len);
        }
    }
}

package snippet;

import java.util.Arrays;

/**
 * 插入排序 过程： 想让arr[0~0]上有序，这个范围只有一个数，当然是有序的。
 * 想让arr[0~1]上有序，所以从arr[1]开始往前看，如果arr[1]<arr[0]，就交换。否则什么也不做。 …
 * 想让arr[0~i]上有序，所以从arr[i]开始往前看，arr[i]这个数不停向左移动，一直移动到左边的数字不再比自己大，停止移动。
 * 最后一步，想让arr[0~N-1]上有序， arr[N-1]这个数不停向左移动，一直移动到左边的数字不再比自己大，停止移动。
 * <p>
 * 估算时发现这个算法流程的复杂程度，会因为数据状况的不同而不同。
 */
public class Code_0001_InsertionSort {
	public static void insertionSort(int[] arr) {
		if (arr != null && arr.length >= 2) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	// 交换arr的i和j位置上的值
	public static void swap(int[] arr, int i, int j) {
		if (arr == null || arr.length < 2 || i == j) {
			return;
		}
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

	// for test
	public static void absRight(int[] arr) {
		Arrays.sort(arr);
	}

	private static int[] generateRandomArray(int maxSize, int maxValue) {
		// Math.random() -> [0,1)
		// Math.random() * N -> [0,N)
		// (int)(Math.random()*N) -> [0,N-1]

		int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
		for (int i = 0; i < arr.length; i++) {
			// [-? , +?]
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
		}
		return arr;
	}

	private static void printArray(int[] arr1) {
		if (null == arr1) {
			return;
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
	}

	private static boolean isEqual(int[] arr1, int[] arr2) {
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1 == null) {
			return false;
		}
		if (arr2 == null) {
			return false;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] copyArray(int[] arr1) {
		if (arr1 == null) {
			return null;
		}
		int[] arr2 = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		return arr2;
	}

	// for test
	public static void main(String[] args) {
		int times = 500000; // 测试的次数
		int maxSize = 100; // 数组的最大长度是100
		int maxValue = 100; // 数组元素的大小[-100,100]
		boolean succeed = true;
		for (int i = 0; i < times; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			insertionSort(arr1);
			absRight(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}

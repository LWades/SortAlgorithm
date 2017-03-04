package MergeSort;

public class MergeSort {

	//�ݹ�汾�Ĺ鲢����
	public void mergeSort_rec(int a[], int left, int right){
		int[] temp = new int[10];
		if (left < right){
			int i = (left + right) / 2;
			mergeSort_rec(a, left, i);
			mergeSort_rec(a, i+1, right);
			merge(a, temp, left, i, right);
			copy(a, temp, left, right);
		}
	}
	
	//��temp���Ƶ�a��
	public void copy(int a[], int temp[], int left, int right){
		for (int i = left; i <= right; i++){
			a[i] = temp[i];
		}
	}
	
	//�����汾�Ĺ鲢����
	public void mergeSort_ite(int a[], int n){
		int[] temp = new int [10];
		int s = 1;
		while (s < n) {
			mergePass(a, temp, s, n);
			s = 2*s;
			mergePass(temp, a, s, n);
			s = 2*s;
		}
	}
	
	//�ϲ���СΪs������������
	public void mergePass(int x[], int y[], int s, int n){
		int i = 0;
		
		while (i + 2*s <= n){
			//�ϲ���СΪs������2��������
			merge(x, y, i, i+s-1, i+2*s-1);
			i = i + 2 *s;
		}
		
		if (i + s < n) {
			merge(x, y, i, i+s-1, n-1);
		}else{
			for (int j = i; j < n-1; j++) {
				y[j] = x[j];
			}
		}
	}
	
	//�ϲ�c[l:m]��c[m+1:r]��d[l:r]
	//�������������ڲ��������Ѿ��ź�����
	public void merge(int c[], int d[], int l, int m, int r){
		int i = l;
		int j = m + 1;
		int k = l;
		//�Ƚ�����Ϊi��j��Ԫ�أ�ȡС�����ηŵ�d������
		while ((i <= m)&&(j <= r)){
			if (c[i] < c[j])
				d[k++] = c[i++];
			else
				d[k++] = c[j++];
		}
		
		if (i > m){
			for (int q = j; q <= r; q++){
				d[k++] = c[q];
			}
		}else{
			for (int q = i; q <= m; q++){
				d[k++] = c[q];
			}
		}
	}
	
	public static void main(String[] args){
		MergeSort mergeSort = new MergeSort();
		int[] test = {4, 3, 5, 7, 1, 8, 2, 6, 9, 0};
		int[] test2 = {2, 1};
//		mergeSort.mergeSort_rec(test, 0, 9);
		mergeSort.mergeSort_ite(test, 10);
		System.out.println(test);
	}
}
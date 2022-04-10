package com.greece.prometheus.graph;

/**
 * ��С��������prim�㷨
 * ��prim�㷨�У�ͨ��������С�ڽӱߵķ�����������С�������㷨��
 * ���ȹ���һ����ͼ����ѡһ����ʼ������뵽�¼����У�Ȼ��ֱ���ԭ�ȵĶ��㼯���г�ȡһ�����㣬
 * ʹ�ù��ɵı�ΪȨֵ��С��Ȼ�󽫸ñ߼��뵽ͼ�У���������Ķ�����뵽�¼����У��ظ�������̣�֪���¼��ϵ���ԭ�ȵļ��ϡ�
 *
 */
public class PrimOne {
	
	public static void prim(int num, float[][] weight) {  //numΪ��������weightΪȨ
		float[] lowcost = new float[num + 1];  //���¼��ϵ���СȨ
		
		int[] closest = new int[num + 1];  //������s������������СȨ�ߵĵ�
		boolean[] s = new boolean[num + 1];  //s[i] == true����i����s������
		s[1] = true;  //����һ�������s����
		for(int i = 2; i <= num; i++) {  //��ʼ����������
			lowcost[i] = weight[1][i];
			closest[i] = 1;
			s[i] = false;
		}
		for(int i = 1; i < num; i++) {
			float min = Float.MAX_VALUE;
			int j = 1;
			for(int k = 2; k <= num; k++) {
				if((lowcost[k] < min) && (!s[k])) {//������СȨ�����µ�
					min = lowcost[k];
					j = k;
				}
			}  
			System.out.println("�����" + j + ". " + j + "---" + closest[j]);//�¼�����j����j�����ĵ�   
			s[j] = true;//�����µ�j
			
			for(int k = 2; k <= num; k++) {
				if((weight[j][k] < lowcost[k]) && !s[k]) {//�����¼���ĵ�j,�����СȨ
					lowcost[k] = weight[j][k];
					closest[k] = j;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//              ��
		//            /  |  /
		//           6   1   5
		//          /    |    /
		//        ��-5--��--5--��
		//         /    //    /
		//          3  6  4  2
		//           //    //
		//           ��--6-��
		//��С������Ϊ��
		//              ��
		//               |   
		//               1    
		//               |     
		//        ��-5--��        ��\
		//         /     /    /
		//          3     4  2
		//           /     //
		//           ��        ��
		//
		float m = Float.MAX_VALUE;
		float[][] weight = {{0, 0, 0, 0, 0, 0, 0},
							{0, m, 6, 1, 5, m, m},
							{0, 6, m, 5, m, 3, m},
							{0, 1, 5, m, 5, 6, 4},
							{0, 5, m, 5, m, m, 2},
							{0, m, 3, 6, m, m, 6},
							{0, m, m, 4, 2, 6, m}};//��ͼ�ľ���
		prim(weight.length - 1, weight);
		//�����3. 3---1
		//�����6. 6---3
		//�����4. 4---6
		//�����2. 2---3
		//�����5. 5---2
	}
}

package com.greece.prometheus.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��һ��[6,18]����һ���������а��Ų�ͬ��Ŀ���飬ʹ������Ŀ���
 *
 */
public class BestArrange {
	
	public static class Program {
		public int start;
		public int end;
		
		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}
		
	}
	
	/**
	 * �ⷨ��:���Ȱ��Ž���ʱ�������Ŀ��Ȼ��ɾ�����ܰ��ŵ���Ŀ����������ʣ����Ŀ�н���ʱ�����
	 */
	public static int bestArrange(Program[] program, int timepoint) {
		Arrays.sort(program, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < program.length; i++) {
			if (timepoint <= program[i].start) {
				result++;
				timepoint = program[i].end;
			}
		}
		return result;
	}

}

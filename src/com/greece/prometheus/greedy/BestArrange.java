package com.greece.prometheus.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在一天[6,18]中在一个会议室中安排不同项目会议，使安排项目最多
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
	 * 解法是:优先安排结束时间早的项目，然后删除不能安排的项目，继续安排剩下项目中结束时间早的
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

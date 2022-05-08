package com.building.construction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class SkyscraperBuilding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the total no of floors in the building");
		int countOfFloors = sc.nextInt();
		int[] floors = new int[countOfFloors];

		for (int i = 0; i < countOfFloors; i++) {
			System.out.println("enter the floor size given on day :" + (i + 1));
			floors[i] = sc.nextInt();
		}

		Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		List<Integer> temp = new ArrayList<>();
		int max = 0;

		for (int i = 0; i < countOfFloors; ++i) {
			temp.add(floors[i]);
			if (floors[i] > max)
				max = floors[i];
		}

		Collections.sort(temp);
		int currentPosition = 0;
		System.out.println("The order of construction is as follows");

		for (int i = 0; i < floors.length; i++) {
			System.out.println("Day: " + (i + 1));
			if (max == floors[i]) {
				if (i == 0) {
					System.out.println(floors[i]);
					currentPosition = floors[i];
				} else {
					System.out.print(floors[i] + " ");
					currentPosition = printOutput(pQueue, temp, floors[i]);
					System.out.println();
				}
			} else if (floors[i] == getNextElement(currentPosition, temp)) {
				System.out.print(floors[i] + " ");
				currentPosition = printOutput(pQueue, temp, floors[i]);
				System.out.println();
			} else {
				System.out.println();
				pQueue.add(floors[i]);
			}
		}
	}

	private static int printOutput(Queue<Integer> pQueue, List<Integer> temp, int value) {
		while (1 <= pQueue.size() && (pQueue.peek() == getNextElement(value, temp))) {
			value = (int) pQueue.peek();
			System.out.print(pQueue.poll() + " ");
		}
		return value;
	}

	private static int getNextElement(int currentPosition, List<Integer> temp) {
		if (currentPosition == 0)
			return -1;
		int nextValue = temp.indexOf(currentPosition) - 1;
		return temp.get(nextValue);
	}

}
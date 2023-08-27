package com.krishna.algorithm.DSAlgo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.krishna.algorithm.DSAlgo.service.BackTrackingService;

@Component
public class BackTrackingServiceImpl implements BackTrackingService{

	@Override
	public int printStringPermutation(String str) {
		
		char[] ar = str.toCharArray();
		
		printStringPermutation(ar,0);
		return 0;
	}

	private void printStringPermutation(char[] ar, int fixed) {
		
		if(fixed+1==ar.length) {
			String str= new String(ar);
			System.out.println(str);
		}else {
			for(int i=fixed;i<ar.length;i++) {
				swap(i,fixed,ar);
				printStringPermutation(ar,fixed+1);
				swap(i,fixed,ar);

			}
		}
		
	}

	private void swap(int i, int fixed, char[] ar) {
		char temp = ar[i];
		ar[i]=ar[fixed];
		ar[fixed]=temp;
	}

	@Override
	public boolean printKnightTour(int n) {
		boolean isTourFound = false;
		int [][] chess = new int [n][n];
		
		int move = 1;
		chess[0][0]= move;
		isTourFound = isKnightTourExist(chess,move,n*n,0,0);
		return isTourFound;
	}

	private boolean isKnightTourExist(int[][] chess, int move, int totalMove, int currentI, int currentJ) {
		if(totalMove==move) {
			printTour(chess);
			return true;
			}
		
			int indexI [] = new int [] {2, 1, -1, -2, -2, -1, 1, 2 };
			int indexJ [] = new int [] {1, 2, 2, 1, -1, -2, -2, -1 };
			int nextI,nextJ;
			for(int i=0;i<8;i++) {
				nextI=currentI+indexI[i];
				nextJ = currentJ+indexJ[i];
				if(isValidMove(nextI,nextJ,chess)) {
					move++;
					chess[nextI][nextJ]=move;
					if(!isKnightTourExist(chess, move, totalMove, nextI, nextJ)) {
						chess[nextI][nextJ]=0;
						move--;
					}else {
						return true;
					}
					
				}
			

		}
		return false;
	}

	private boolean isValidMove(int nextI, int nextJ, int[][] chess) {
		boolean isValid = false;
		int size = chess.length;
		if(nextI>=0&&nextI<size&&nextJ>=0&&nextJ<size&&chess[nextI][nextJ]==0)
			isValid=true;
		return isValid;
	}

	private void printTour(int[][] chess) {
		for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess.length;j++) {
				System.out.print(chess[i][j]+" ");
			}
			System.out.println();
		}
	}

	@Override
	public boolean getNqueen(int n) {
		boolean isNqueenExist = false;
		
		int [][] chess = new int [n][n];
		Set<String> set = new HashSet<String>();
		isNqueenExist = findNqueenPlace(chess,0,set);
		return isNqueenExist;
	}

	private boolean findNqueenPlace(int[][] chess, int col, Set<String> set) {
		if(col==chess.length)
		{
			printTour(chess);
			return true;
		}
		
		for(int i=0;i<chess.length;i++) {
			if(QueenSafe(i,col,set)) {
				chess[i][col]=1;
				set.add(i+":"+col);
				if(findNqueenPlace(chess, col+1, set)) {
					return true;
				}else {
					chess[i][col]=0;
					set.remove(i+":"+col);
				}
			}
		}
		return false;
	}

	private boolean QueenSafe(int i, int col, Set<String> set) {
		boolean safe = true;
		int qi,qj;
		int sum = i+col;
		int sub= i-col;
		for(String postion: set) {
			String [] IJ = postion.split(":");
			qi= Integer.parseInt(IJ[0]);
			qj= Integer.parseInt(IJ[1]);
			if((qi+qj)==sum) {
				safe=false;
				break;
			}
			if((qi-qj)==sub) {
				safe=false;
				break;
			}
			if(qi==i||qj==col) {
				safe=false;
				break;
				
			}
				

		}
		return safe;
	}

	@Override
	public boolean getHamltonianPath(int[][] ar) {
		boolean isHamltonian = false;
		List<Integer> hamltonian = new ArrayList<Integer>();
		hamltonian.add(0);
		isHamltonian=isHamltonianPathExist(ar,0,hamltonian);
		
		return isHamltonian;
	}

	private boolean isHamltonianPathExist(int[][] ar, int i, List<Integer> hamltonian) {
		if(hamltonian.size()==ar.length && isFirstExist(ar,i)) {
			printHamltonianPath(hamltonian);
			return true;
			
		}
		
		for(int j=0;j<ar.length;j++) {
			if(ar[i][j]==1&&!hamltonian.contains(j)) {
				hamltonian.add(j);
				if(isHamltonianPathExist(ar, j, hamltonian)) {
					return true;
				}else {
					hamltonian.remove(j);
				}
			}
		}
		
		return false;
	}

	private void printHamltonianPath(List<Integer> hamltonian) {
		for(int i : hamltonian) {
			System.out.println(i);
		}
	}

	private boolean isFirstExist(int[][] ar, int i) {
		boolean isFirstExist = false;
		for(int j=0;j<ar.length;j++) {
			if(ar[i][j]==0) {
				isFirstExist= true;
			}
				
		}
		return isFirstExist;
	}

	@Override
	public boolean getSudoku(int[][] ar) {
		
		boolean isSudokuExist = false;
		
		Set<String> fixed = new HashSet<String>();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(!(ar[i][j]==0))
					fixed.add(i+""+j);
			}
		}
		fixed.add(-1+""+-1);

		isSudokuExist = getSudoku(-1,-1,ar,fixed);
		
		return isSudokuExist;
	}

	private boolean getSudoku(int i, int j, int[][] ar, Set<String> fixed) {
		if(i==8&&j==8) {
			printSudoku(ar);
			return true;
		}
		
		int [][] IJ = getNextIJ(i,j,fixed,ar);
		if(IJ[0][0]>8&&IJ[0][1]>8) {
			printSudoku(ar);
			return true;

		}
		int nextI = IJ[0][0];
		int nextJ = IJ[0][1];
		
		for(int k=1;k<10;k++) {
			if(validSudoku(nextI,nextJ,k,ar)) {
				ar[nextI][nextJ]=k;
				if(getSudoku(nextI, nextJ, ar, fixed)) {
					return true;
				}else {
					ar[nextI][nextJ]=0;

				}
			}
		}
		
		return false;
	}

	private boolean validSudoku(int nextI, int nextJ, int k, int[][] ar) {
		boolean isValid = true;
		for(int i=0;i<9;i++)
		{
			if(ar[nextI][i]==k ||ar[i][nextJ]==k) {
				isValid=false;
			}
		}
		int iStart,iEnd,jStart,jEnd;
		iStart = getStartIndex(nextI);
		jStart = getStartIndex(nextJ);
		iEnd=iStart+3;
		jEnd=jStart+3;
		
		for(int i=iStart;i<iEnd;i++) {
			for(int j=jStart;j<jEnd;j++) {
				if(ar[i][j]==k) {
				 isValid = false;

				}
			}
		}

			
		return isValid;
	}

	private int getStartIndex(int index) {
		int start;
		if(index<3)
			start=0;
		else if(index>2&&index<6)
			start=3;
		else 
			start=6;
		return start;
	}

	private int[][] getNextIJ(int i, int j, Set<String> fixed, int[][] ar) {
		int [][] IJ = new int [1][2];
		if(i==2&j==6) {
			System.out.println();
		}
		boolean flag = false;
		if(i==-1&&j==-1&&!fixed.contains(0+""+0))
		{
			i++;j++;
		}
		else 
		{	
			if(i==-1&&j==-1)
			{
				i++;j++;
			}else if(j<8)
				j++;
			else {
				i++;
				j=0;
			}
			while(i<9||j<9) {
				if(!(fixed.contains(i+""+j))) {
					
					break;
				}
				if(j<8)
					j++;
				else {
					i++;
					j=0;
				}
			}
			for(i=i;i<9;i++)
			{
				for(j=j;j<9;j++) {
					if(!(fixed.contains(i+""+j))) {
										
						flag=true;
						break;
					}
				}
			if(flag)
				break;
		}}
		IJ[0][0]=i;
		IJ[0][1]=j;
		if(i==9&j==9)
			j=j;
			
		
		return IJ;
	}

	private void printSudoku(int[][] ar) {
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++) {
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}

}

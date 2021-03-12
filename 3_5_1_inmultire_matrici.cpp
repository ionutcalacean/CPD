#include "pch.h"
#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

#define SIZE 250

int main(void)
{

	float A[SIZE][SIZE], B[SIZE][SIZE], C[SIZE][SIZE], total;
	int i, j, k,tid;
	total = 0.0;
	for (i = 0; i < SIZE; i++)
	{
		for (j = 0; j < SIZE; j++) {
			A[i][j] = (j + 1) * 1.0;
			B[i][j] = (j + 1) * 1.0;
			C[i][j] = 0.0;
		}
	}

	printf("\nStarting values of matrix A :\n");
	for (i = 0; i < SIZE; i++)
	{
		//printf("\n");
		for (j = 0; j < SIZE; j++) {
		//	printf("%.1f ", A[i][j]);
		}		
		
	}
	printf("\nStarting values of matrix B :\n");
	for (i = 0; i < SIZE; i++)
	{
		//printf("\n");
		for (j = 0; j < SIZE; j++) {
			//printf("%.1f ", B[i][j]);
		}

	}
	printf("\nStarting values of matrix C :\n");
	for (i = 0; i < SIZE; i++)
	{
		//printf("\n");
		for (j = 0; j < SIZE; j++) {
			//printf("%.1f ", C[i][j]);
		}

	}
	printf("\nResults by thread/row:\n");
	
	/* Create a team of threads and scope variables */

	omp_set_num_threads(8);
	omp_set_nested(1);
	double start_time = omp_get_wtime();
#pragma omp parallel shared(A,B,C,total) private(tid,i,j,k)
	{tid = omp_get_thread_num();
	/* Loop work-sharing construct - distribute rows of matrix */
	printf("I am thread nr %d\n", tid);
	

#pragma omp for 
	for (i = 0; i < SIZE; i++)
	{
		for (j = 0; j < SIZE; j++)
		{
			for (k = 0; k < SIZE; k++)
			{
				C[i][j] += A[i][k] * B[k][j];
			}
		}
	}

	}
	double time = omp_get_wtime() - start_time;
	printf("TOTAL TIME %f\n", time);

	printf("\END values of matrix C :\n");
	for (i = 0; i < SIZE; i++)
	{
		//printf("\n");
		for (j = 0; j < SIZE; j++) {
			//printf("%.1f ", C[i][j]);
		}

	}
	

}
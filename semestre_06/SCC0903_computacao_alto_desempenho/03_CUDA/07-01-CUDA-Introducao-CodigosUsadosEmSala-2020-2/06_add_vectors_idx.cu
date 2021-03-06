#include <stdlib.h>
#include <stdio.h>
#include <math.h>

#define N   10000
#define TPB 128 /* indica o no. de threads por bloco */

__global__ void add( int *a, int *b, int *c ) {
    /*
     * threadIdx.x contém o Id da thread a ser executada
     * blockIdx.x contém o Id do bloco
     * blockDim.x contém o nr de threads utilizadas em cada bloco
     * gridDim.x contém o nr de blocos utilizados em um grid
     */
	 
    int tid = threadIdx.x + blockIdx.x * blockDim.x;    // this thread handles the data at its thread id

	if(tid<N){
	        c[tid] = a[tid] + b[tid];
	}
    /**
     * O While adapta a funcao para percorrer vetor maior do que o alocado
     */

//    while (tid < N){

//        c[tid] = a[tid] + b[tid];
//    	tid+= blockDim.x * gridDim.x;
//    }
}

int main( void ) {
    int a[N], b[N], c[N];
    int *dev_a, *dev_b, *dev_c;

    // allocate the memory on the GPU
    cudaMalloc( (void**)&dev_a, N * sizeof(int));
    cudaMalloc( (void**)&dev_b, N * sizeof(int));
    cudaMalloc( (void**)&dev_c, N * sizeof(int));

    // fill the arrays 'a' and 'b' on the CPU
    for (int i=0; i<N; i++) {
        a[i] = -i;
        b[i] = i * i;
    }

    // copy the arrays 'a' and 'b' to the GPU
    cudaMemcpy( dev_a, a, N * sizeof(int),cudaMemcpyHostToDevice);
    cudaMemcpy( dev_b, b, N * sizeof(int),cudaMemcpyHostToDevice);

    /**
     *  Aloca uma quantidade maior de blocos para o processamento dos dados
     *  Função add não utiliza dados desnecessários
     */
	printf("N=%d, TPB=%d, Nr Blocos=%d \n", N, TPB, ((N + TPB - 1)/ TPB));
	
    add<<<((N+TPB-1)/TPB),TPB>>>(dev_a,dev_b,dev_c);

    // copy the array 'c' back from the GPU to the CPU
    cudaMemcpy(c, dev_c, N * sizeof(int),cudaMemcpyDeviceToHost);

    // display the results
    for (int i=0; i<N; i++) {
	if(i%1000==0)
        printf( "%d + %d = %d\n", a[i], b[i], c[i] );
    }

    // free the memory allocated on the GPU
    cudaFree(dev_a);
    cudaFree(dev_b);
    cudaFree(dev_c);

	getchar();

    return 0;
}

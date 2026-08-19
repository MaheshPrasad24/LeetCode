/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned in *returnColumnSizes.
 */
int* findSmallestSetOfVertices(int n, int** edges, int edgesSize,
                               int* edgesColSize, int* returnSize) {

    int* indegree = (int*)calloc(n, sizeof(int));

    // Count incoming edges
    for (int i = 0; i < edgesSize; i++) {
        int to = edges[i][1];
        indegree[to]++;
    }

    // Count nodes with indegree 0
    int count = 0;

    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            count++;
        }
    }

    // Create answer array
    int* answer = (int*)malloc(count * sizeof(int));

    int index = 0;

    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            answer[index++] = i;
        }
    }

    *returnSize = count;

    free(indegree);

    return answer;
}
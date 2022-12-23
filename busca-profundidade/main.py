

from multiprocessing.dummy import Array
import numpy as np

i = 1
while ( i <= 1 ):
    aquivoDeInstancia = open('ORLib/pmed{}.txt'.format(i), "r") 
    int_list = []
    for line in aquivoDeInstancia.readlines():
         int_list.append([int(i) for i in line.split()])
    # for l in int_list:
    #    print(l)
    print('Processando...')
    vertices = int_list[0][0]
    arestas = int_list[0][1]
    int_list.pop(0)
    graph = np.array([[0]*(vertices+1) for _ in range(vertices+1)])

    for l in int_list:
         graph[l[0]][l[1]] = 1

    s = [[str(e) for e in row] for row in graph]
    lens = [max(map(len, col)) for col in zip(*s)]
    fmt = '\t'.join('{{:{}}}'.format(x) for x in lens)
    table = [fmt.format(*row) for row in s]
    print ('\n'.join(table))
    i+=1



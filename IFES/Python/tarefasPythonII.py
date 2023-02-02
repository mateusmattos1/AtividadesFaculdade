#Letra a)

def quantLinhas(mat):
	k=0
	for i in mat:
		k=k+1
	return k
	
#Letra b)

def quantColunas(mat):
    k=0
    x=0
    for i in mat[0]:
        for j in range(len(str(i))):
            x+=1
    return x
             
#Letra c)

def soma(matA, matB):
    soma=[]
    registro=0
    tamlinhasa=len(matA)
    tamlinhasb=len(matB)
    tamcolunasa=len(matA[0])
    tamcolunasb=len(matB[0])
    if tamlinhasa == tamlinhasb and tamcolunasa == tamcolunasb:
        for i in range(tamlinhasa):
            lista=[]
            for j in range(tamcolunasb):
                registro=int(matA[i][j])+int(matB[i][j])
                lista.append(registro)
                registro=0
            soma.append(lista)
        return soma
    else:
        return None

#Letra d)

def vezes_k(mat, k):
	multiplicadeus=0
	multiplicadojesus=[]
	lista=[]
	for i in range(len(mat)):
		for j in range(len(mat[0])):
			multiplicadeus=int(mat[i][j])*k
			lista.append(multiplicadeus)
			multiplicadeus=0
		multiplicadojesus.append(lista)
		lista=[]
	return multiplicadojesus
    ()

#Letra e)

def f_matrivazia(matA, matB):
    matrizvazia=[]
    for i in range(len(matA)):
        m=[]
        for j in range(len(matB[0])):
            m=m+[0]
        matrizvazia.append(m)
    return matrizvazia

def multi(matA, matB):
    c=0
    if len(matA[0]) == len(matB):
        m=f_matrivazia(matA, matB)
        for i in range(len(matA)):
            for j in range(len(matB[0])):
                for k in range(len(matA[0])):
                    m[i][j]=m[i][j]+(matA[i][k]*matB[k][j])
        return m
    else:
        return None

#Letra f)

def f_matrizvazia(mat):
	soma=[]
	for i in range(len(mat)):
		m=[]
		for k in range(len(mat[0])):
			m=m+[0]
		soma.append(m)
	return soma

def clona(mat):
	m=f_matrizvazia(mat)
	for i in range(len(mat)):
		for k in range(len(mat[0])):
			m[i][k]=mat[i][k]
	return m

#Letra g)

def diag_p(mat):
	if len(mat) == len(mat[0]):
		m=mat
		lista=[]
		for i in range(len(m)):
			for j in range(len(m)):
				if j == i:
					lista.append(m[i][j])
		return lista
	else:
		return None       

#Letra h)

def diag_s(mat):
    if len(mat) == len(mat[0]):
        m=mat
        lista=[]
        y=len(mat[0])-1
        x=0
        while x < len(mat):
            lista.append(mat[x][y])
            x=x+1
            y=y-1
        return lista
    return None
            
#Letra i)

def vizinhos(mat,i,j):
    lista=[]
    tamlinhas=i-1
    tamcolunas=len(mat[0])
    if tamlinhas >= 0:
        if j - 1 >= 0:
            lista.append(mat[i-1][j-1])
        lista.append(mat[i-1][j])
        if j + 1 <= len(mat[0]):
            lista.append(mat[i-1][j+1])
    else:
        lista.append(None)
        lista.append(None)
        lista.append(None)
    if j + 1 <= len(mat[0]):
        lista.append(mat[i][j+1])
    else:
        lista.append(None)
    if tamlinhas+2 <= len(mat)-1:
        if j - 1 >= 0:
            lista.append(matriz[i+1][j-1])
        else:
            lista.append(None)
        lista.append(matriz[i+1][j])
        if j + 1 <= len(mat[0])-1:
            lista.append(matriz[i+1][j+1])
    else:
        lista.append(None)
        lista.append(None)
        lista.append(None)
    if j - 1 >= 0:
        lista.append(matriz[i][j-1])
    else:
        lista.append(None)
    return lista
                    
#Letra j)

def igual(matA,matB):
    x=0
    if len(matA) == len(matB) and len(matA[0]) == len(matB[0]):
        for i in range(len(matA)):
            for j in range(len(matB[0])):
                if matA[i][j] == matB[i][j]:
                    x=x+x
                else:
                    x=x+1
        if x == 0:
            return True
        else:
            return False
    else:
        return False

#Letra k)

def extrai(mat,i,j,tamLin,tamCol):
    extrair=[]
    if (i >= 0) and (i <= len(mat)) and (j >= 0) and (j <= len(mat[0])) and (tamLin <= (len(mat)) - i) and (tamCol <= (len(mat[0]) - j)):
        for s in range(i,tamLin+i):
            lista=[]
            for f in range(j,tamCol+j):
                lista.append(mat[s][f])
            extrair.append(lista)
        return extrair
    else:
        return None

#Letra l)

def insere(matA,matB,i,j):
    resultado=[]
    if len(matB) <= len(matA) and len(matA) - i >= len(matB) and len(matB[0]) <= len(matA[0]) and len(matA[0]) - j >= len(mat):
        for a in range(len(matB)):
            for b in range(len(matB[0])):
                matA[a+i][b+j]=matB[a][b]
        return matA
    else:
        return None        

#Letra m)

def desloca_esq(mat):
    resultado=[]
    for i in range(len(mat)):
        lista=[]
        for j in range(len(mat[0])-1):
            lista.append(mat[i][j+1])
            if len(mat[0]) - j == 2:
                lista.append(0)
        resultado.append(lista)
    return resultado

#Letra n)

def desloca_dir(mat):
    resultado=[]
    for i in range(len(mat)):
        lista=[]
        for j in range(len(mat[0])):
            if j == 0:
                lista.append(0)
            else:
                lista.append(mat[i][j-1])
        resultado.append(lista)
    return resultado

#Letra o)

def matrizvaziaa(mat):
    linhas=len(mat)
    colunas=len(mat[0])
    matrizvazia=[]
    for i in range(colunas):
        lista=[]
        for j in range(linhas):
            lista.append(0)
        matrizvazia.append(lista)
    return matrizvazia

def rot_90d(mat):
    matrizvazia=matrizvaziaa(mat)
    for i in range(len(mat)):
        lista=[]
        for j in range(len(mat[0])):
            matrizvazia[j][len(mat)-1-i]=mat[i][j]
    return matrizvazia

#Letra p)

def matrizvaziaa(mat):
    linhas=len(mat)
    colunas=len(mat[0])
    matrizvazia=[]
    for i in range(colunas):
        lista=[]
        for j in range(linhas):
            lista.append(0)
        matrizvazia.append(lista)
    return matrizvazia

def rot_90e(mat):
    matrizvazia=matrizvaziaa(mat)
    for i in range(len(mat)):
        lista=[]
        for j in range(len(mat[i])):
            matrizvazia[len(matrizvazia)-1-j][i]=mat[i][j]
    return matrizvazia

#Letra q)

def vetoriza(mat):
	lista=[]
	for i in range(len(mat)):
		for j in range(len(mat[0])):
			lista.append(mat[i][j])
	return lista

#Letra r)

def carrega(<arquivo>):
	arq1 = open('arquivo.txt','rt')
	texto = arq1.read()
	resultado=[]
	lista=[]
	aux=''
	i=0
	while i < len(texto):
		if texto[i].isalnum():
			aux+=texto[i]
		elif texto[i] == ' ':
			lista.append(int(aux))
			aux=''
		elif texto[i] == "\n":
			lista.append(int(aux))
			resultado.append(lista)
			lista=[]
			aux=''
		i+=1
	lista.append(int(aux))
	resultado.append(lista)
	print (resultado)
	arq1.close()
	return 0
main()

#Letra s)

def salva(mat,<arquivo>):
	tam=len(mat[0])-1
	arq = open('arquivo.txt', 'wt')
	for i in range(len(mat)):
		for j in range(len(mat[0])):
			if tam == j:
				arq.write(str(mat[i][j]))
				arq.write('\n')
			else:
				arq.write(str(mat[i][j]))
				arq.write(' ')
	arq.close()
	return 0
main()

#Letra t)

def tarefa(ma,mb,alfa):
	for i in range(len(ma)):
		for j in range(len(ma)):
			if mb[i][j] == alfa:
				mb[i][j]=alfa
	return mb

#Falta t, u, v, w e x. 

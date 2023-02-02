def main():
	
	print ("Eis aqui os dicionários:")
	#abertura dos arquivos
	ptin = open('pt_in.txt', 'r')
	ptit = open('pt_it.txt', 'r')
	ptes = open('pt_es.txt', 'r')
	ptfr = open('pt_fr.txt', 'r')
	
	#referentes ao ingles
	palavrasin = ""
	pal1 = ""
	pal2 = ""
	
	#refentes ao italiano
	palavrasit = ""
	pal3 = ""
	pal4 = ""
	
	#referente ao espanhol
	palavrases = ""
	pal5 = ""
	pal6 = ""
	
	#refente ao frances
	palavrasfr = ""
	pal7 = ""
	pal8 = ""
	
	#dicionarios:
	
	#dicionario em ingles
	dicionarioin = {}
	
	#dicionario em italiano
	dicionarioit = {}
	
	#dicionario em espanhol
	dicionarioes = {}
	
	#dicionario em frances
	dicionariofr = {}
	
	#laços para criação dos dicionários
	for a in range (5):
		
		dicin = ptin.readline()
		dicit = ptit.readline()
		dices = ptes.readline()
		dicfr = ptfr.readline()
		
		#laço para o ingles
		for b in range(len(dicin)):
			
			if dicin[b] == ",":
				pal1 = palavrasin
				palavrasin = ""
				
			else:
				if dicin[b] != " ":
					palavrasin = palavrasin + dicin[b]
		
		#laço para o italiano
		for c in range(len(dicit)):
			
			if dicit[c] == ",":
				pal3 = palavrasit
				palavrasit = ""
				
			else:
				if dicit[c] != " ":
					palavrasit = palavrasit + dicit[c]
		
		#laço para o espanhol
		for d in range(len(dices)):
			
			if dices[d] == ",":
				pal5 = palavrases
				palavrases = ""
				
			else:
				if dices[d] != " ":
					palavrases = palavrases + dices[d]
		
		#laço para o frances
		for e in range(len(dicfr)):
			
			if dicfr[e] == ",":
				pal7 = palavrasfr
				palavrasfr = ""
				
			else:
				if dicfr[e] != " ":
					palavrasfr = palavrasfr + dicfr[e]
		
		#complementando dicionário em ingles
		pal2 = palavrasin
		palavrasin = ""
		pal2 = pal2.rstrip()
			
		dicionarioin [pal1] = pal2
		
		#complementando dicionário em italiano
		pal4 = palavrasit
		palavrasit = ""
		pal4 = pal4.rstrip()
		
		dicionarioit [pal3] = pal4
		
		#complementando dicionário em espanhol
		pal6 = palavrases
		palavrases = ""
		pal6 = pal6.rstrip()
		
		dicionarioes [pal5] = pal6
		
		#complementando dicionário em frances
		pal8 = palavrasfr
		palavrasfr = ""
		pal8 = pal8.rstrip()
		
		dicionariofr [pal7] = pal8
		
	#encerramentos
	ptin.close()
	ptit.close()
	ptes.close()
	ptfr.close()
	
	#print dos dicionarios para teste
	print ("\n")
	print ("Italiano:",dicionarioit)					
	print ("Inglês:",dicionarioin)
	print ("Espanhol:",dicionarioes)
	print ("Frances:",dicionariofr)
	
	#parte da tradução, inicais
	print ("\n")
	print ("!As opções são pt, in, fr, it, es.!")
	
	traducao = ""
	auxiliar = ""
	
	print ("\n")
	origem = input("Digite a língua origem da palavra: ")
	
	#palavra pt
	if origem == "pt":
		palavra = input("Digite a palavra: ")
		final = input("Digite a língua para qual será traduzida: ")
		
		#em ingles
		if final == "in":
			for portugues,ingles in dicionarioin.items():
				if palavra == portugues:
					traducao = ingles
					
		#em italiano
		if final == "it":
			for portugues, italiano in dicionarioit.items():
				if palavra == portugues:
					traducao = italiano
					
		#em espanhol
		if final == "es":
			for portugues,espanhol in dicionarioes.items():
				if palavra == portugues:
					traducao = espanhol
					
		#em frances
		if final == "fr":
			for portugues, frances in dicionariofr.items():
				if palavra == portugues:
					traducao = frances
	
	#palavra in
	if origem == "in":
		palavra = input("Digite a palavra: ")
		final = input("Digite a língua para qual será traduzida: ")
		
		#em portugues
		if final == "pt":
			for portugues,ingles in dicionarioin.items():
				if palavra == ingles:
					traducao = portugues
					
		#em italiano
		if final == "it":
			for portugues, ingles in dicionarioin.items():
				if palavra == ingles:
					auxiliar = portugues
			for portugues1, italiano in dicionarioit.items():
				if portugues1 == auxiliar:
					traducao = italiano
				
		#em espanhol
		if final == "es":
			for portugues, ingles in dicionarioin.items():
				if palavra == ingles:
					auxiliar = portugues
			for portugues1, espanhol in dicionarioes.items():
				if portugues1 == auxiliar:
					traducao = espanhol
					
		#em frances
		if final == "fr":
			for portugues, ingles in dicionarioin.items():
				if palavra == ingles:
					auxiliar = portugues
			for portugues1, frances in dicionariofr.items():
				if portugues1 == auxiliar:
					traducao = frances
		
	#palavra it
	if origem == "it":
		palavra = input("Digite a palavra: ")
		final = input("Digite a língua para qual será traduzida: ")
		
		#em ingles
		if final == "in":
			for portugues, italiano in dicionarioit.items():
				if palavra == italiano:
					auxiliar = portugues
			for portugues1, ingles in dicionarioin.items():
				if portugues1 == auxiliar:
					traducao = ingles
		
		#em portugues
		if final == "pt":
			for portugues, italiano in dicionarioit.items():
				if italiano == palavra:
					traducao = portugues
			
		#em espanhol
		if final == "es":
			for portugues, italiano in dicionarioit.items():
				if palavra == italiano:
					auxiliar = portugues
			for portugues1, espanhol in dicionarioes.items():
				if portugues1 == auxiliar:
					traducao = espanhol
		
		#em frances
		if final == "fr":
			for portugues, italiano in dicionarioit.items():
				if palavra == italiano:
					auxiliar = portugues
			for portugues1, frances in dicionariofr.items():
				if portugues1 == auxiliar:
					traducao = frances
		
	# palavra es	
	if origem == "es":
		palavra = input("Digite a palavra: ")
		final = input("Digite a língua para qual será traduzida: ")
		
		#em ingles
		if final == "in":
			for portugues, espanhol in dicionarioes.items():
				if palavra == espanhol:
					auxiliar = portugues
			for portugues1, ingles in dicionarioin.items():
				if portugues1 == auxiliar:
					traducao = ingles
					
		#em portugues
		if final == "pt":
			for portugues, espanhol in dicionarioes.items():
				if espanhol == palavra:
					traducao = portugues
					
		#em italiano
		if final == "it":
			for portugues, espanhol in dicionarioes.items():
				if palavra == espanhol:
					auxiliar = portugues
			for portugues1, italiano in dicionarioit.items():
				if portugues1 == auxiliar:
					traducao = italiano
			
		#em frances
		if final == "fr":
			for portugues, espanhol in dicionarioes.items():
				if palavra == espanhol:
					auxiliar = portugues
			for portugues1, frances in dicionariofr.items():
				if portugues1 == auxiliar:
					traducao = frances
			
	#palavra fr
	if origem == "fr":
		palavra = input("Digite a palavra: ")
		final = input("Digite a língua para qual será traduzida: ")
		
		#em ingles
		if final == "in":
			for portugues, frances in dicionariofr.items():
				if palavra == frances:
					auxiliar = portugues
			for portugues1, ingles in dicionarioin.items():
				if portugues1 == auxiliar:
					traducao = ingles
			
		#em portugues
		if final == "pt":
			for portugues, frances in dicionariofr.items():
				if frances == palavra:
					traducao = portugues
			
		#em espanhol
		if final == "es":
			for portugues, frances in dicionariofr.items():
				if palavra == frances:
					auxiliar = portugues
			for portugues1, espanhol in dicionarioes.items():
				if portugues1 == auxiliar:
					traducao = espanhol
		
		#em italiano
		if final == "it":
			for portugues, frances in dicionariofr.items():
				if palavra == frances:
					auxiliar = portugues
			for portugues1, italiano in dicionarioit.items():
				if portugues1 == auxiliar:
					traducao = italiano
					
	#resultado final
	print ("\n")
	print ("A palavra -",palavra, "- de origem -",origem, "- em -", final,"- é",traducao,".")
	return 0
main()

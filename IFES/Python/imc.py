from tkinter import *

def main():
	painel=Tk()
	painel.geometry("200x200")

	frame1=Frame(height=30)
	frame2=Frame()
	frame3=Frame(height=25)
	frame4=Frame()
	frame5=Frame()
	frame6=Frame()
	frame7=Frame(height=15)
	frame8=Frame()
	frame9=Frame()

	titulo=Label(frame2, text = "Índice Massa Corporal")
	nome1=Label(frame4, text="Peso (em kg): ", width=15)
	peso=Entry(frame4, width=7)
	nome2=Label(frame5, text="Altura (em metros): ", width=15)
	altura=Entry(frame5, width=7)
	calcular=Button(frame6, text="Calcular IMC")
	resultado=Label(frame8)
	classif=Label(frame9)

	frame1.pack()
	frame2.pack()
	frame3.pack()
	frame4.pack()
	frame5.pack()
	frame6.pack()
	frame7.pack()
	frame8.pack()
	frame9.pack()
	titulo.pack()
	nome1.pack(side=LEFT)
	peso.pack(side=LEFT)
	nome2.pack(side=LEFT)
	altura.pack(side=LEFT)
	calcular.pack()
	resultado.pack(side=LEFT)
	classif.pack()

	calculo=lambda e: imc(peso,altura,resultado,classif)
	calcular.bind("<Button-1>", calculo)

	painel.mainloop()

def imc(peso, altura, resultado, classificacao):
	imc1 = float(peso.get()) / (float(altura.get()) ** 2)
	imc2 = str(imc1)[0:5]

	resultado["text"] = "IMC: " + imc2

	if imc1 < 17:
		classificacao["text"] = "Classificação: Muito abaixo do peso"
	if imc1 > 17 and imc1 < 18.49:
		classificacao["text"] = "Classificação: Abaixo do peso"
	if imc1 > 18.5 and imc1 < 24.99:
		print("cheguei")
		classificacao["text"] = "Classificação: Peso normal"
	if imc1 > 25 and imc1 < 29.99:
		classificacao["text"] = "Classificação: Acima do peso"
	if imc1 > 30 and imc1 < 34.99:
		classificacao["text"] = "Classificação: Obesidade I"
	if imc1 > 35 and imc1 < 39.99:
		classificacao["text"] = "Classificação: Obesidade II"
	if imc1 > 40:
		classificacao["text"] = "Classificação: Obesidade III"

main()

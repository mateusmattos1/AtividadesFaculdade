from tkinter import *
import math

def f_senoid(x):
    mat = math.sin(math.radians(x)) 
    return mat
    
def f_cossenoide(x):
    mat = math.cos(math.radians(x))
    return mat

def transportarpontos(lst, baseret, alturaret, origYret, origXret):
    j = 2
    lista = []

    for i in range(len(lst)):
        m = j%2
        if m == 0:
            xb = (lst[i]*baseret/360)+origXret
            lista.append(xb)
        else:
            yb = ((lst[i]*alturaret/2)*(-1))+origYret
            lista.append(yb)
        j += 1
    return lista

def main():
    janela = Tk()
    jan_height = 300
    jan_width = 500
    tela_de_desenho = Canvas (janela , bg = "white" , height = jan_height , width = jan_width)
    lst = []
    lst1 = []
    ret1 = tela_de_desenho.create_rectangle(15,15,200,125, fill = "red")
    baseret = 200 - 15
    alturaret = 125 - 15
    origYret = (125 // 2) + 8
    origXret = 15
    for x in range(0,360):
        sen = f_senoid(x)
        lst.append(x)
        lst.append(sen)
        cos = f_cossenoide(x)
        lst1.append(x)
        lst1.append(cos)
    mapeamento = transportarpontos(lst, baseret, alturaret, origYret, origXret)
    linha1 = tela_de_desenho.create_line(mapeamento, fill = "blue")  
    lines = tela_de_desenho.create_line(origXret, origYret, baseret+15, origYret, fill = "blue")
    
    ret2 = tela_de_desenho.create_rectangle(300, 50, 450, 150, fill = "black")
    baseret = 450 - 300
    alturaret = 150 - 50
    origYret = (100 // 2) + 50
    origXret = 300
    mapeamento = transportarpontos(lst1, baseret, alturaret, origYret, origXret)
    linha2 = tela_de_desenho.create_line(mapeamento, fill = "yellow")
    lines = tela_de_desenho.create_line(300, origYret, baseret+300, origYret, fill = "yellow")
    
    a, b, c = 1, 3, -4
    delta = (b**2)*((-4)*a*c)
    
    xv = (-b)//(2*a)
    yv = -delta//(4*a)
    
    
    tela_de_desenho.pack()
    janela.mainloop()
    
    return 0
main()

README									 A*vis
								A*vis Composer
								Ilari Richardt
								     16.2.2014
4.1 K��nt�minen

K��nt�minen tapahtuu NetBeans IDE:ll� Run -> Build (F11)

4.2 Ajaminen

Ohjelma ajetaan komennolla
java -jar AStarVis.jar

tai 

java -jar AStarVis.jar <kuvatiedosto>
Kuvatiedostossa pit�� olla yksi
aloituspikseli r=0,g=255,b=0
lopetuspikseli r=255,g=0,b=0
N�it� pikseleit� EI saa l�yty� enemp�� kuin 1kpl
Suositeltu kuvakoko on 30x40 px

4.3 K�ytt�minen

Ohjelman p��ikkuna ottaa vastaan erilaisia n�pp�in komentoja
R: luo uusi satunnainen verkko painoilla (A*vis ratkaisee ja animoi ratkaisun)
M: luo labyrintti (A*vis ratkaisee ja animoi ratkaisun)
C: avaa "A*vis Composer", jolla voit luoda omia verkkoja
D: Vaihda ratkaisuheurastiikaksi suuntaava funktio
N: Vaihda ratkaisuheurastiikaksi omia painoja katsova funktio

Kun vaihdat ratkaisuheurastiikkaa sinun t�ytyy joko A) painaa R, M tai muuttaa
"composer":ssa verkkoasi

A*vis Composer ohje:
Painamalla hiiren vasenta n�pp�int� voit kasvattaa ruudun painoa 50:ll�
yksik�ll� (voit my�s maalata ruutuja)

painamalla hiiren oikeaa n�pp�int� jollekin ruudullee muuttuu se
aloitusruuduksi (vihre�)

kun painat jollekin aloitusruudulle toisen kerran oikeaa n�pp�int� muuttuu se
lopetusruuduksi.

HUOM: A* algoritmi ratkaisee vain yhdest� alkupisteest� yhteen p��t�spisteeseen.
Suurin x,y koordinaatillinen alku/lopetuspiste valitaan siis ratkaisuun mukaan.

Composerin saa tyhjennetty� sulkemalla ikkunan ja painamalla C uudestaan A*vis
p��ikkunassa (avaa uuden composerin)


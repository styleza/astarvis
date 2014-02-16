README									 A*vis
								A*vis Composer
								Ilari Richardt
								     16.2.2014
4.1 Kääntäminen

Kääntäminen tapahtuu NetBeans IDE:llä Run -> Build (F11)

4.2 Ajaminen

Ohjelma ajetaan komennolla
java -jar AStarVis.jar

tai 

java -jar AStarVis.jar <kuvatiedosto>
Kuvatiedostossa pitää olla yksi
aloituspikseli r=0,g=255,b=0
lopetuspikseli r=255,g=0,b=0
Näitä pikseleitä EI saa löytyä enempää kuin 1kpl
Suositeltu kuvakoko on 30x40 px

4.3 Käyttäminen

Ohjelman pääikkuna ottaa vastaan erilaisia näppäin komentoja
R: luo uusi satunnainen verkko painoilla (A*vis ratkaisee ja animoi ratkaisun)
M: luo labyrintti (A*vis ratkaisee ja animoi ratkaisun)
C: avaa "A*vis Composer", jolla voit luoda omia verkkoja
D: Vaihda ratkaisuheurastiikaksi suuntaava funktio
N: Vaihda ratkaisuheurastiikaksi omia painoja katsova funktio

Kun vaihdat ratkaisuheurastiikkaa sinun täytyy joko A) painaa R, M tai muuttaa
"composer":ssa verkkoasi

A*vis Composer ohje:
Painamalla hiiren vasenta näppäintä voit kasvattaa ruudun painoa 50:llä
yksiköllä (voit myös maalata ruutuja)

painamalla hiiren oikeaa näppäintä jollekin ruudullee muuttuu se
aloitusruuduksi (vihreä)

kun painat jollekin aloitusruudulle toisen kerran oikeaa näppäintä muuttuu se
lopetusruuduksi.

HUOM: A* algoritmi ratkaisee vain yhdestä alkupisteestä yhteen päätöspisteeseen.
Suurin x,y koordinaatillinen alku/lopetuspiste valitaan siis ratkaisuun mukaan.

Composerin saa tyhjennettyä sulkemalla ikkunan ja painamalla C uudestaan A*vis
pääikkunassa (avaa uuden composerin)


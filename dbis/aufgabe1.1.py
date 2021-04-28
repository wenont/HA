from assets.ER import ERDiagram

g = ERDiagram()
g.neuer_knoten("Benutzer")
g.neues_attribut("Benutzer", "Name")
g.neues_attribut("Benutzer", "EMail", primaer=True)
g.neues_attribut("Benutzer", "Nickname")
g.neues_attribut("Benutzer", "Laender")

g.neuer_knoten("Rezension")
g.neues_attribut("Rezension", "Nummer", primaer=True)
g.neues_attribut("Rezension", "Zusammenfassung")
g.neues_attribut("Rezension", "Datum")
g.neues_attribut("Rezension", "Sprache")
g.neue_relation("Benutzer", "schreibt ", "Rezension", "1", "n")

g.neuer_knoten("Kommentar")
g.neue_relation("Rezension", "enthaelt", "Kommentar", "1", "n",schwach=True)
g.neues_attribut("Kommentar", "Freitext")
g.neues_attribut("Kommentar", "Datum")
g.neues_attribut("Kommentar", "FortlaufendeNummer", primaer=True)
g.neue_relation("Kommentar", "antworten", "Kommentar", "1", "n")
g.neue_relation("Benutzer", "schreibt", "Kommentar", "1", "n")


g.neuer_knoten("Ort")
g.neue_relation("Rezension", "bezieht sich auf", "Ort", "n", "1")
g.neues_attribut("Ort", "Name")
g.neues_attribut("Ort", "Nummer", primaer=True)
g.neues_attribut("Ort", "Adresse",zusammengesetzt_aus=["Straße", "PLZ", "Stadt","Land"])
g.neues_attribut("Ort", "GPS",zusammengesetzt_aus=["Laengengrad","Breitengrad"])

g.neuer_knoten("Hotel")
g.neuer_knoten("Spielplatz")
g.neuer_knoten("Restaurant")
g.neuer_knoten("Geschaeft")
g.ist_ein("Ort", ["Hotel", "Spielplatz", "Restaurant","Geschaeft"], "t", disjunkt=True)
g.neues_attribut("Hotel", "AnzahlDerSterne")
g.neues_attribut("Spielplatz", "Spielgeraete", mehrfach=True)
g.neues_attribut("Restaurant", "Kategorie")
g.neues_attribut("Geschaeft", "Typ")

g.draw()
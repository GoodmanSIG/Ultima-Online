# utek
sub portAway()
var runa = 0x43C4B48D; #id runy

IF UO.Count("0x1F4C") > 0 then
uo.usetype("0x1F4C")
uo.waittargetobject(runa)
ELSE
uo.cast("Recall")
uo.waittargetobject(runa)
UO.PRINT("NEMAS RECALLI!!!")
END IF
endsub

# leceni sebe
sub healSelf()
VAR stit = 0x1B76; #haether

#VAR zbran = 0x0F48; #blood ba
#var zbran = 0x13AF; #silver war axe
#var zbran = 0x13B9; #viking
var zbran = 0x26CE; #black sword

While UO.Life<UO.STR-5
UO.DeleteJournal()
UO.WaitTargetSelf()
While Uo.Targeting()
Wait(100)
wend
UO.UseType(0x0e21)
wait(200)
UO.Usetype(stit)
repeat
wait(100)
Until UO.InJournal("Chces vytvorit mumii|You put the bloody |You apply the bandages|Leceni se nezdarilo|Prvni pomoc se podarila|Prerusil si pokus|Unexpected")
if UO.InJournal('pomoc se podarila') then
UO.Print(str(UO.Life))
endif
#nasazeni stitu
wend

#nasazeni zbrane
uo.waittargetobject('self')
UO.Usetype(stit)
wait(100)
uo.usetype(zbran)
end sub

# nasazeni luku
sub luk()
UO.Usetype('0x13B1')
endsub

# stealth
sub hiding()
UO.warmode(0);
While NOT UO.Dead()
UO.DeleteJournal()
UO.UseSkill('Hiding')
Repeat
wait(100)
Until UO.InJournal('Povedlo se ti')
return
   Wend
end sub

# taming
sub taming()
Uo.DeleteJournal()
Uo.Print("Klikni na zvire")
Uo.Exec("addobject zvire")
While Uo.Targeting()
Wait(500)
wend

While NOT Uo.Dead()
Uo.DeleteJournal()
Uo.UseSkill("Animal Taming","zvire")
Repeat
Wait(300)
Until Uo.Injournal("byl ochocen!|nepodarilo!|je jiz ochoceny|Jsi daleko!|bylo preruseno")
If Uo.Injournal("accept you|byl ochocen!|je jiz ochoceny|Jsi daleko!|bylo preruseno|jeste nemuzes") then
Uo.Exec("terminate taming")
UO.print('konec ochocovani')
endif
wend
end sub

# meditating
sub meditation()
if UO.Mana < UO.Int then
UO.warmode(0);
endif

while UO.Mana < UO.Int
Uo.DeleteJournal()
UO.UseSkill('Meditation') #meditace
repeat
wait(100)
until UO.injournal('Ztratil si soustredeni|Byl jsi vytrzen|Tva magicka energie|brneni')
wend
endsub




# leceni sebe
sub healSelf()
VAR stit = 0x1B74; #kite

#VAR zbran = 0x0F48; #blood ba
var zbran = 0x2D24; #diamond mace
#var zbran = 0x13B9; #viking
#var zbran = 0x26CE; #black sword

While UO.Life<UO.STR-5
UO.DeleteJournal()
UO.WaitTargetSelf()
While Uo.Targeting()
Wait(100)
wend
UO.UseType(0x0e21)
wait(200)
UO.Usetype(stit)
repeat
wait(100)
Until UO.InJournal("Chces vytvorit mumii|You put the bloody |You apply the bandages|Leceni se nezdarilo|Prvni pomoc se podarila|Prerusil si pokus|Unexpected")
if UO.InJournal('pomoc se podarila') then
UO.Print(str(UO.Life))
endif
#nasazeni stitu
wend

#nasazeni zbrane
uo.waittargetobject('self')
UO.Usetype(stit)
wait(100)
uo.usetype(zbran)
end sub

# utek
sub portAway()
var runa = 0x43EE4C9B; #id runy

IF UO.Count("0x1F4C") > 0 then
uo.usetype("0x1F4C")
uo.waittargetobject(runa)
ELSE
uo.cast("Recall")
uo.waittargetobject(runa)
UO.PRINT("NEMAS RECALLI!!!")
END IF
endsub

# sbirani regentu
sub harvestRegent()
DIM regs[4]
regs[0] = 0x18E1; #garlic
regs[1] = 0x18DF; #mandrake
regs[2] = 0x18E9; #ginseng
regs[3] = 0x18E5; #night shade

var i;
harvesting:
for i = 0 to 3
UO.DeleteJournal()
uo.print(str(i))
uo.set("finddistance",2)
uo.findtype(regs[i], "-1", "ground")
while uo.findcount() > 0
UO.UseFromGround(regs[i])

repeat
wait(50)
until UO.InJournal('do sveho batohu.')
wait(1800)
wend
#goto harvesting
next
end sub

sub lumberjacking()
var sekera = 0x0F47 #hatchet 0x0F43
UO.DeleteJournal()	
while UO.Weight < UO.STR*3.7

UO.DeleteJournal()
UO.Print('Vyber strom')
UO.UseType(sekera)
repeat
repeat
wait(200)
until UO.InJournal('ale bez uspechu|Vkladas|Uz tu neni|moc daleko|zbytecne|Unexpected|zbytecne|Nedosahnes|Nevis|Unexpected|Zkus sekat jinde')	

if UO.InJournal('Vkladas|bez uspechu') then
UO.Print(str(uo.count('0x1bdd','0x0000')))
UO.DeleteJournal()
UO.WaitTargetTile('lasttile')
UO.UseType(sekera)
endif
until UO.InJournal('ale bez uspechu|Vkladas|Uz tu neni|moc daleko|Nedosahnes|Unexpeted|zbytecne|Nedosahnes|Nevis|Unexpected')
wait(500)
wend
UO.Print('Jsi plny')
end sub

sub fishingcool()
var mx, my, mz, i, j
uo.print('Kam davat ryby ?')
uo.exec('addobject Bag')
while uo.targeting()
wait(100)
wend
while UO.SkillVal("Fishing",1) < 1010
mx = UO.GetX("self")
my = UO.GetY("self")
mz = UO.GetZ("self")
UO.DeleteJournal()
for i = mx-4 to mx+4
for j = my -4 to my+4
if UO.dead() then
return
endif
UO.Print("Now Fishing In: "+str(mx-i)+" "+str(my-j))
while not UO.InJournal("Jeste nemuzes znovu nahodit.|rybarit jinde|zadne ryby|so close")
UO.DeleteJournal()
Wait(200)
UO.Waittargettile("1341", str(i), str(j), str(mz))
UO.Usetype("0x0DBF") ;FishingPole
if UO.dead() then
return
endif
if UO.Weight>660 then
return
endif
while not UO.InJournal("Vytahujes|rybarit jinde|zadne ryby|nechytla.")
wait (200)
if UO.InJournal("Vytahujes") then
UO.SetReceivingContainer('Bag')
UO.findtype('0x09CC','0x0000','ground') ;fish
UO.grab ('3','finditem')
wait (100)
UO.findtype('0x09CD','0x0000','ground') ;fish
UO.grab ('3','finditem')
wait (100)
UO.findtype('0x09CE','0x0000','ground') ;fish
UO.grab ('3','finditem')
wait (100)
UO.findtype('0x09CF','0x0000','ground') ;fish
UO.grab ('3','finditem')
wait (100)
UO.UnSetReceivingContainer()
end if
wend
wend
UO.DeleteJournal()
next

next
wend
end sub

sub smelt()
uo.print("truhla")
uo.addobject("truhla")
while uo.Targeting()
wait(100)
wend

dim ore[3]
ore[0] = "0x19B9"
ore[1] = "0x19B8"
ore[2] = "0x19BA"
For var i = 0 to 2
While UO.FindType(ore[i],"-1","truhla") > 0
#uo.print('nase, sem, prenasim')
UO.MoveItem("finditem", 1, "backpack", 150, 50, 0)
Wait(1000)
UO.UseFromGround("0x0FB1")
UO.WaitTargetType("0x19B7")
wait(1000)
Repeat
Wait(100)
Until UO.InJournal("do sveho batohu|canceled|Povedlo se ti|cancelled")
UO.DeleteJournal()

if UO.count('0x1BEF') > 30 then
UO.print('prenasim ingoty do truhly')
Uo.FindType("0x1BEF","-1","backpack")
Uo.Moveitem("finditem","0","truhla")
wait(1000)
endif
Wend
Next
end sub

sub Mining1()
;----------------------------
; Nastaveni vyhazovani
; 1 - vyhodit
; 0 - ponechat v batohu
DIM odrop[26]
odrop[0] = 1 ;iron
odrop[1] = 1 ;rusty
odrop[2] = 0 ;silver
odrop[3] = 1 ;old copper
odrop[4] = 1 ;dull copper
odrop[5] = 1 ;copper
odrop[6] = 1 ;bronze
odrop[7] = 1 ;gold
odrop[8] = 1 ;shadow
odrop[9] = 1 ;agapite
odrop[10] = 1 ;verite
odrop[11] = 0 ;valorite
odrop[12] = 0 ;rose
odrop[13] = 0 ;blood rock
odrop[14] = 0 ;black rock
odrop[15] = 0 ;bantitan
odrop[16] = 0 ;mytheril
odrop[17] = 0 ;uniculium
odrop[18] = 0 ;ametyst
odrop[19] = 1 ;citrine
odrop[20] = 1 ;sapphire
odrop[21] = 0 ;tourmaline
odrop[22] = 1 ;star sapphire
odrop[23] = 1 ;ruby
odrop[24] = 1 ;emerald
odrop[25] = 0 ;diamant
;----------------------------
; Nastaveni vypnuti po kopnuti urcite rudy
; 1 - vypnout
; 0 - kopat dal
DIM kend[26]
kend[0] = 0
kend[1] = 1
kend[2] = 1
kend[3] = 1
kend[4] = 1
kend[5] = 1
kend[6] = 0
kend[7] = 0
kend[8] = 1
kend[9] = 0
kend[10] = 0
kend[11] = 0
kend[12] = 0
kend[13] = 0
kend[14] = 0
kend[15] = 0
kend[16] = 0
kend[17] = 0
kend[18] = 0
kend[19] = 0
kend[20] = 0
kend[21] = 0
kend[22] = 0
kend[23] = 0
kend[24] = 0
kend[25] = 0
;----------------------------

VAR id = "0x19B9"
DIM orecolor[26]
orecolor[0] = "0x0000" ;iron
orecolor[1] = "0x0BA9" ;rusty
orecolor[2] = "0x07A1" ;silver
orecolor[3] = "0x07E4" ;old copper
orecolor[4] = "0x07D8" ;dull copper
orecolor[5] = "0x07CC" ;copper
orecolor[6] = "0x07EA" ;bronze
orecolor[7] = "0x0798" ;gold
orecolor[8] = "0x19B9" ;shadow
orecolor[9] = "0x0794" ;agapite
orecolor[10] = "0x07D1" ;verite
orecolor[11] = "0x0BA8" ;valorite
orecolor[12] = "0x0665" ;rose
orecolor[13] = "0x07E5" ;blood rock
orecolor[14] = "0x0455" ;black rock
orecolor[15] = "0x07EB" ;bantitan
orecolor[16] = "0x0796" ;mytheril
orecolor[17] = "0x0BB6" ;uniculium
orecolor[18] = "0x0015" ;ametyst
orecolor[19] = "0x002C" ;citrine
orecolor[20] = "0x025E" ;sapphire
orecolor[21] = "0x0038" ;tourmaline
orecolor[22] = "0x0006" ;star sapphire
orecolor[23] = "0x0027" ;ruby
orecolor[24] = "0x0041" ;emerald
orecolor[25] = "0x08AE" ;diamant
;----------------------------

DIM end[26]
end[0] = "Vkladas iron"
end[1] = "Vkladas rusty"
end[2] = "Vkladas silver"
end[3] = "Vkladas old copper"
end[4] = "Vkladas dull copper"
end[5] = "Vkladas copper"
end[6] = "Vkladas bronze"
end[7] = "Vkladas golden"
end[8] = "Vkladas shadow"
end[9] = "Vkladas agapite"
end[10] = "Vkladas verite"
end[11] = "Vkladas valorite"
end[12] = "Vkladas rose"
end[13] = "Vkladas bloodrock"
end[14] = "Vkladas blackrock"
end[15] = "Vkladas bantitan"
end[16] = "Vkladas mytheril"
end[17] = "Vkladas uniculium"
end[18] = "Vkladas Amethyst"
end[19] = "Vkladas Citrine"
end[20] = "Vkladas Sapphire"
end[21] = "Vkladas Tourmaline"
end[22] = "Vkladas Star Sapphire"
end[23] = "Vkladas Ruby"
end[24] = "Vkladas Emerald"
end[25] = "Vkladas Diamond"
;----------------------------

VAR walks = 0
VAR a = 1
dim walksmer[2]
walksmer[0]=33
walksmer[1]=35
dim change[2]
change[0]=40
change[1]=39


VAR kop1 = "Povedlo se ti odkopat"
VAR kop2 = "Vkladas"
VAR kop3 = "Neni tu co kopat"
VAR kop4 = "daleko|Zkus kopat|Nevidis tam"
VAR kop5 = "Try mining"
VAR drop,ende,kopx,kopy,i
mining:
UO.warmode(0);
Uo.DeleteJournal()
Uo.WaitTargetTile("0",Uo.Getx()+1,Uo.Gety(),Uo.GetZ())
Uo.UseType("0x0E85")
While NOT Uo.InJournal(kop1) and NOT Uo.InJournal(kop2) and NOT Uo.InJournal(kop3) and NOT Uo.InJournal(kop4) and NOT Uo.InJournal(kop5)
Wait(100)
Wend

If Uo.InJournal(kop1) then
goto mining
endif

If Uo.InJournal(kop3) or Uo.InJournal(kop4) or Uo.InJournal(kop5) then
goto chuze
endif
for drop = 0 to 25
If Uo.Count(id,orecolor[drop]) and odrop[drop] == 1 then
Uo.FindType(id,orecolor[drop],"-1","backpack")
Uo.Moveitem("finditem","0","ground")
Endif
next

for ende = 0 to 25
If Uo.InJournal(end[ende]) and kend[ende] == 0 then
goto mining
Endif
next

chuze:
kopx = Uo.getx()
kopy = Uo.gety()
uo.press(walksmer[walks])
wait(500)

if uo.getx() == kopx and uo.gety() == kopy then
kopx = uo.getx()
kopy = uo.gety()
uo.press(walksmer[walks])
wait(500)
if uo.getx() == kopx and uo.gety() == kopy then
for i = 0 to a
uo.press(change[walks])
next
if walks == 0 then
walks = 1
else
walks = 0
endif
endif
goto walk
endif
goto mining:
end sub

sub kop()
VAR stop = 9
Uo.Exec("terminate Mining1")
Uo.Press(stop)
UO.UseType("0x0F09")
Uo.Waittargetobject("0x440C1F48")
Uo.UseType("0x1F4C")
end sub
######

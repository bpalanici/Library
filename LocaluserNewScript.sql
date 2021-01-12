DECLARE
TYPE varr IS VARRAY(1000) OF varchar(255);
  lista_nume varr := varr('Ababei','Acasandrei','Adascalitei','Afanasie','Agafitei','Agape','Aioanei','Alexandrescu','Alexandru','Alexe','Alexii','Amarghioalei','Ambroci','Andonesei','Andrei','Andrian','Andrici','Andronic','Andros','Anghelina','Anita','Antochi','Antonie','Apetrei','Apostol','Arhip','Arhire','Arteni','Arvinte','Asaftei','Asofiei','Aungurenci','Avadanei','Avram','Babei','Baciu','Baetu','Balan','Balica','Banu','Barbieru','Barzu','Bazgan','Bejan','Bejenaru','Belcescu','Belciuganu','Benchea','Bilan','Birsanu','Bivol','Bizu','Boca','Bodnar','Boistean','Borcan','Bordeianu','Botezatu','Bradea','Braescu','Budaca','Bulai','Bulbuc-aioanei','Burlacu','Burloiu','Bursuc','Butacu','Bute','Buza','Calancea','Calinescu','Capusneanu','Caraiman','Carbune','Carp','Catana','Catiru','Catonoiu','Cazacu','Cazamir','Cebere','Cehan','Cernescu','Chelaru','Chelmu','Chelmus','Chibici','Chicos','Chilaboc','Chile','Chiriac','Chirila','Chistol','Chitic','Chmilevski','Cimpoesu','Ciobanu','Ciobotaru','Ciocoiu','Ciofu','Ciornei','Citea','Ciucanu','Clatinici','Clim','Cobuz','Coca','Cojocariu','Cojocaru','Condurache','Corciu','Corduneanu','Corfu','Corneanu','Corodescu','Coseru','Cosnita','Costan','Covatariu','Cozma','Cozmiuc','Craciunas','Crainiceanu','Creanga','Cretu','Cristea','Crucerescu','Cumpata','Curca','Cusmuliuc','Damian','Damoc','Daneliuc','Daniel','Danila','Darie','Dascalescu','Dascalu','Diaconu','Dima','Dimache','Dinu','Dobos','Dochitei','Dochitoiu','Dodan','Dogaru','Domnaru','Dorneanu','Dragan','Dragoman','Dragomir','Dragomirescu','Duceac','Dudau','Durnea','Edu','Eduard','Eusebiu','Fedeles','Ferestraoaru','Filibiu','Filimon','Filip','Florescu','Folvaiter','Frumosu','Frunza','Galatanu','Gavrilita','Gavriliuc','Gavrilovici','Gherase','Gherca','Ghergu','Gherman','Ghibirdic','Giosanu','Gitlan','Giurgila','Glodeanu','Goldan','Gorgan','Grama','Grigore','Grigoriu','Grosu','Grozavu','Gurau','Haba','Harabula','Hardon','Harpa','Herdes','Herscovici','Hociung','Hodoreanu','Hostiuc','Huma','Hutanu','Huzum','Iacob','Iacobuta','Iancu','Ichim','Iftimesei','Ilie','Insuratelu','Ionesei','Ionesi','Ionita','Iordache','Iordache-tiroiu','Iordan','Iosub','Iovu','Irimia','Ivascu','Jecu','Jitariuc','Jitca','Joldescu','Juravle','Larion','Lates','Latu','Lazar','Leleu','Leon','Leonte','Leuciuc','Leustean','Luca','Lucaci','Lucasi','Luncasu','Lungeanu','Lungu','Lupascu','Lupu','Macariu','Macoveschi','Maftei','Maganu','Mangalagiu','Manolache','Manole','Marcu','Marinov','Martinas','Marton','Mataca','Matcovici','Matei','Maties','Matrana','Maxim','Mazareanu','Mazilu','Mazur','Melniciuc-puica','Micu','Mihaela','Mihai','Mihaila','Mihailescu','Mihalachi','Mihalcea','Mihociu','Milut','Minea','Minghel','Minuti','Miron','Mitan','Moisa','Moniry-abyaneh','Morarescu','Morosanu','Moscu','Motrescu','Motroi','Munteanu','Murarasu','Musca','Mutescu','Nastaca','Nechita','Neghina','Negrus','Negruser','Negrutu','Nemtoc','Netedu','Nica','Nicu','Oana','Olanuta','Olarasu','Olariu','Olaru','Onu','Opariuc','Oprea','Ostafe','Otrocol','Palihovici','Pantiru','Pantiruc','Paparuz','Pascaru','Patachi','Patras','Patriche','Perciun','Perju','Petcu','Pila','Pintilie','Piriu','Platon','Plugariu','Podaru','Poenariu','Pojar','Popa','Popescu','Popovici','Poputoaia','Postolache','Predoaia','Prisecaru','Procop','Prodan','Puiu','Purice','Rachieru','Razvan','Reut','Riscanu','Riza','Robu','Roman','Romanescu','Romaniuc','Rosca','Rusu','Samson','Sandu','Sandulache','Sava','Savescu','Schifirnet','Scortanu','Scurtu','Sfarghiu','Silitra','Simiganoschi','Simion','Simionescu','Simionesei','Simon','Sitaru','Sleghel','Sofian','Soficu','Sparhat','Spiridon','Stan','Stavarache','Stefan','Stefanita','Stingaciu','Stiufliuc','Stoian','Stoica','Stoleru','Stolniceanu','Stolnicu','Strainu','Strimtu','Suhani','Tabusca','Talif','Tanasa','Teclici','Teodorescu','Tesu','Tifrea','Timofte','Tincu','Tirpescu','Toader','Tofan','Toma','Toncu','Trifan','Tudosa','Tudose','Tuduri','Tuiu','Turcu','Ulinici','Unghianu','Ungureanu','Ursache','Ursachi','Urse','Ursu','Varlan','Varteniuc','Varvaroi','Vasilache','Vasiliu','Ventaniuc','Vicol','Vidru','Vinatoru','Vlad','Voaides','Vrabie','Vulpescu','Zamosteanu','Zazuleac');
  lista_prenume_fete varr := varr('Adina','Alexandra','Alina','Ana','Anca','Anda','Andra','Andreea','Andreia','Antonia','Bianca','Camelia','Claudia','Codrina','Cristina','Daniela','Daria','Delia','Denisa','Diana','Ecaterina','Elena','Eleonora','Elisa','Ema','Emanuela','Emma','Gabriela','Georgiana','Ileana','Ilona','Ioana','Iolanda','Irina','Iulia','Iuliana','Larisa','Laura','Loredana','Madalina','Malina','Manuela','Maria','Mihaela','Mirela','Monica','Oana','Paula','Petruta','Raluca','Sabina','Sanziana','Simina','Simona','Stefana','Stefania','Tamara','Teodora','Theodora','Vasilica','Xena');
  lista_prenume_baieti varr := varr('Adrian','Alex','Alexandru','Alin','Andreas','Andrei','Aurelian','Beniamin','Bogdan','Camil','Catalin','Cezar','Ciprian','Claudiu','Codrin','Constantin','Corneliu','Cosmin','Costel','Cristian','Damian','Dan','Daniel','Danut','Darius','Denise','Dimitrie','Dorian','Dorin','Dragos','Dumitru','Eduard','Elvis','Emil','Ervin','Eugen','Eusebiu','Fabian','Filip','Florian','Florin','Gabriel','George','Gheorghe','Giani','Giulio','Iaroslav','Ilie','Ioan','Ion','Ionel','Ionut','Iosif','Irinel','Iulian','Iustin','Laurentiu','Liviu','Lucian','Marian','Marius','Matei','Mihai','Mihail','Nicolae','Nicu','Nicusor','Octavian','Ovidiu','Paul','Petru','Petrut','Radu','Rares','Razvan','Richard','Robert','Roland','Rolland','Romanescu','Sabin','Samuel','Sebastian','Sergiu','Silviu','Stefan','Teodor','Teofil','Theodor','Tudor','Vadim','Valentin','Valeriu','Vasile','Victor','Vlad','Vladimir','Vladut');
  lista_genuri varr := varr('Action and adventure',	'Art', 'Alternate history', 'Autobiography', 'Anthology', 'Biography', 'Chick lit', 'Book review', 'Childrens literature', 'Cookbook', 'Comic book', 'Diary', 'Coming-of-age', 'Dictionary', 'Crime', 'Encyclopedia', 'Drama', 'Guide', 'Fairytale', 'Health', 'Fantasy', 'History', 'Graphic novel', 'Journal', 'Historical fiction', 'Math', 'Horror', 'Memoir', 'Mystery', 'Prayer', 'Paranormal', 'romance', 'Religion', 'spirituality', 'new age', 'Picture book',	'Textbook', 'Poetry', 'Review', 'Political', 'thriller', 'Science', 'Romance', 'Self', 'help', 'Satire', 'Travel', 'Science', 'fiction', 'True', 'crime', 'Short story', 'Suspense', 'Thriller', 'Young adult');
  lista_subgenuri varr:= varr('Fiction', 'Historical Fiction', 'Realistic Fiction', 'Science Fiction', 'Fantasy', 'Mystery', 'Nonfiction', 'Autobiography', 'Memoir', 'Biography', 'Reference', 'Information', 'Newspaper', 'Poetry', 'Play Folk', 'Tale', 'Epic', 'Poetry', 'Lyric Poetry', 'Dramatic Poetry', 'Comedy', 'Tragedy', 'Melodrama',  'Absurd', 'Action Comedies', 'Anarchic Comedies', 'Animals',  'Black Comedies', 'British Humor', 'Buddy', 'Classic Comedies', 'Clown', 'Comedy Thrillers', 'Comic Criminals', 'Coming of Age', 'Conceptual', 'Crime/Caper Comedies', 'Fairy Tale', 'Family Comedy', 'Farce', 'Gross-out Comedies', 'Horror Comedies',  'Lampoon', 'Mafia Comedies', 'Biblical', 'British Empire', 'Costume Epics', 'Dark Ages', 'Greek Myth', 'Hagiographies', 'Indian History', 'Action Sci-Fi', 'Alien Invasion', 'Aliens' , 'Space Invaders', 'Anime', 'AI',  'Atomic Age', 'Classic Sci-Fi', 'Creature Films', 'Disaster', 'End of World', 'Exploration');
  lista_opinii varr := varr( 'Nu are suficienta actiune', 'Nu mi-a placut', 'Nu este de actualitate', 'Nu e pe gustul meu',
                                    'Placuta', 'Suficient de captivanta', 'Subiectul este abordat pe larg','Buna', 'Interesanta', 'Uimitoare', 'Fenomenala');

  --readers
  v_nume VARCHAR(255);
  v_prenume VARCHAR(255);
  v_prenume1 VARCHAR(255);
  v_prenume2 VARCHAR(255);
  v_data_nastere date;
  v_totalfine int;
  v_user varchar(255);
  v_password varchar(255);

  --other ones
  v_gen varchar(255);
  v_subgen varchar(255);
  v_bookID int;
  v_readerID int;
  v_score Number;
  v_Review Varchar(255);

  --books
  v_The int;
  v_OrAndNothing int;
  v_bookname varchar(255) := '';
  v_random_noun varchar(255);
  v_random_adjective varchar(255);
  v_AuthorID int;
  v_isbn varchar(255);
  v_nrPages int;
  v_price number(6,2);
  v_rating number(6,2);
  v_isborowed int;
  v_loanDate Date;
  v_returnDate Date;
  
  --book name lists
  lista_adjective varr := varr('long', 'maniacal', 'enchanted', 'tearful', 'absurd', 'wiry', 'possible', 'subdued', 'invincible', 'numerous', 'complete', 'sweltering', 'amusing', 'animated', 'maddening', 'skillful', 'hissing', 'pricey', 'good', 'righteous', 'near', 'earthy', 'faint', 'unhealthy', 'careless', 'neighborly', 'wrathful', 'horrible', 'doubtful', 'bloody', 'meaty', 'even', 'rare', 'symptomatic', 'small', 'private', 'mysterious', 'huge', 'overjoyed', 'best', 'upset', 'married', 'teeny', 'rich', 'odd', 'stormy', 'flat', 'elated', 'nippy', 'delicate', 'clumsy', 'irate', 'absorbed', 'probable', 'chief', 'hesitant', 'many', 'resonant', 'eatable', 'nonchalant', 'noxious', 'stale', 'anxious', 'knotty', 'marked', 'disgusting', 'historical', 'gleaming', 'thoughtless', 'smoggy', 'violent', 'broken', 'one', 'lacking', 'embarrassed', 'dusty', 'rambunctious', 'medical', 'detailed', 'overrated', 'abstracted', 'penitent', 'cooing', 'bite-sized', 'uninterested', 'spectacular', 'frightening', 'cowardly', 'freezing', 'barbarous', 'versed', 'cheap', 'quickest', 'evanescent', 'phobic', 'fat', 'half', 'annoyed', 'craven', 'educated', 'deep', 'honorable', 'nosy', 'plucky', 'possessive', 'unusual', 'depressed', 'lonely', 'dry', 'brawny', 'smooth', 'tricky', 'grotesque', 'charming', 'grouchy', 'flaky', 'unique', 'alert', 'frequent', 'bustling', 'capable', 'bad', 'volatile', 'spotty', 'towering', 'loutish', 'productive', 'proud', 'black-and-white', 'overconfident', 'sparkling', 'outstanding', 'hospitable', 'tranquil', 'alluring', 'petite', 'creepy', 'agreeable', 'successful', 'fanatical', 'utter', 'yummy', 'rude', 'weary', 'kind', 'obscene', 'valuable', 'three', 'hilarious', 'shaggy', 'grumpy', 'boring', 'jazzy', 'outrageous', 'hurt', 'weak', 'swanky', 'sturdy', 'straight', 'oafish', 'berserk', 'obsolete', 'crazy', 'squealing', 'threatening', 'sassy', 'silent', 'wicked', 'unaccountable', 'jealous', 'efficient', 'ritzy', 'wasteful', 'raspy', 'loose', 'round', 'imperfect', 'last', 'tasty', 'crowded', 'coherent', 'solid', 'roomy', 'glossy', 'lying', 'afraid', 'smart', 'far-flung', 'simple', 'skinny', 'fumbling', 'fearful', 'puzzling', 'befitting', 'keen', 'vivacious', 'false', 'ultra', 'damp', 'different', 'vulgar', 'permissible', 'sore', 'peaceful', 'accessible', 'full', 'wary', 'imaginary', 'healthy', 'sedate', 'judicious', 'needy', 'scintillating', 'far', 'automatic', 'homely', 'electric', 'glamorous', 'ossified', 'grateful', 'flowery', 'steady', 'high', 'flagrant', 'envious', 'tacky', 'high-pitched', 'present', 'voracious', 'cagey', 'bright', 'jaded', 'exotic', 'fascinated', 'white', 'beneficial', 'cool', 'lyrical', 'glorious', 'well-groomed', 'decorous', 'guttural', 'discreet', 'hypnotic', 'shaky', 'literate', 'lively', 'hateful', 'simplistic', 'unknown', 'remarkable', 'fantastic', 'rampant', 'obnoxious', 'merciful', 'mammoth', 'ragged', 'assorted', 'enormous', 'furtive', 'exciting', 'adamant', 'ancient', 'piquant', 'ten', 'gigantic', 'spicy', 'angry', 'narrow', 'pointless', 'wet', 'daffy', 'four', 'quaint', 'wild', 'ceaseless', 'ashamed', 'defeated', 'previous', 'nondescript', 'overwrought', 'obese', 'receptive', 'loud', 'disturbed', 'bored', 'fallacious', 'diligent', 'smelly', 'axiomatic', 'giant', 'normal', 'measly', 'noiseless', 'shy', 'natural', 'ablaze', 'onerous', 'yellow', 'brash', 'direful', 'attractive', 'juicy', 'hanging', 'needless', 'steep', 'abnormal', 'female', 'black', 'unwritten', 'mountainous', 'alcoholic', 'sick', 'mixed', 'miniature', 'fluffy', 'boundless', 'gainful', 'substantial', 'makeshift', 'guarded', 'damaged', 'various', 'stingy', 'icy', 'bright', 'shrill', 'acceptable', 'excellent', 'cuddly', 'idiotic', 'thin', 'slim', 'accurate', 'obedient', 'tiny', 'gullible', 'shiny', 'actually', 'youthful', 'cut', 'impolite', 'red', 'wrong', 'vigorous', 'agonizing', 'belligerent', 'royal', 'knowing', 'naive', 'reflective', 'slippery', 'easy', 'unsuitable', 'labored', 'six', 'unruly', 'frail', 'dark', 'lackadaisical', 'icky', 'conscious', 'cute', 'equal', 'known', 'verdant', 'spiritual', 'dapper', 'gusty', 'tan', 'low', 'awake', 'guiltless', 'exuberant', 'tenuous', 'clammy', 'draconian', 'devilish', 'breezy', 'internal', 'level', 'ill-informed', 'hurried', 'nifty', 'sharp', 'nonstop', 'adjoining', 'laughable', 'faithful', 'selfish', 'nine', 'dynamic', 'racial', 'scary', 'sticky', 'ethereal', 'lazy', 'imminent', 'feeble', 'hallowed', 'colorful', 'stimulating', 'mere', 'perfect', 'nutritious', 'nutty', 'mindless', 'furry', 'curly', 'milky', 'aloof', 'stupid', 'highfalutin', 'like', 'undesirable', 'rightful', 'momentous', 'dysfunctional', 'groovy', 'certain', 'husky', 'flippant', 'awesome', 'gentle', 'voiceless', 'callous', 'standing', 'chilly', 'modern', 'used', 'distinct', 'obsequious', 'cluttered', 'disillusioned', 'pretty', 'womanly', 'moldy', 'incredible', 'well-made', 'venomous', 'languid', 'astonishing', 'breakable', 'magenta', 'helpful', 'grey', 'friendly', 'living', 'mute', 'oceanic', 'five', 'cloudy', 'little', 'parallel', 'left', 'splendid', 'unbiased', 'wholesale', 'right', 'wanting', 'tiresome', 'uncovered', 'handsomely', 'tart', 'longing', 'thoughtful', 'majestic', 'mighty', 'plausible', 'second', 'tightfisted', 'military', 'tacit', 'melted', 'placid', 'exclusive', 'selective', 'calculating', 'innate', 'redundant', 'hideous', 'feigned', 'fretful', 'eight', 'blushing', 'decisive', 'inexpensive', 'evasive', 'encouraging', 'cloistered', 'festive', 'neat', 'large', 'heady', 'godly', 'worthless', 'rapid', 'physical', 'elderly', 'picayune');
  lista_substantive varr := varr('wool', 'fork', 'pocket', 'anger', 'test', 'poison', 'impulse', 'corn', 'chess', 'volcano', 'balance', 'produce', 'badge', 'spy', 'trade', 'punishment', 'water', 'ship', 'book', 'thumb', 'song', 'play', 'fruit', 'mom', 'hate', 'plantation', 'cherry', 'error', 'fly', 'seashore', 'clover', 'chicken', 'silk', 'snails', 'acoustics', 'winter', 'popcorn', 'rub', 'plane', 'butter', 'store', 'suggestion', 'women', 'floor', 'knife', 'visitor', 'flesh', 'cars', 'beginner', 'downtown', 'tin', 'love', 'rod', 'grape', 'driving', 'bridge', 'burst', 'activity', 'change', 'cactus', 'road', 'wren', 'zinc', 'curtain', 'territory', 'lace', 'bike', 'cakes', 'beef', 'destruction', 'time', 'vegetable', 'transport', 'crayon', 'grass', 'rat', 'quicksand', 'shop', 'vessel', 'engine', 'fowl', 'plot', 'bed', 'beds', 'oatmeal', 'sink', 'division', 'giants', 'slope', 'purpose', 'yard', 'fire', 'temper', 'hair', 'skirt', 'pin', 'uncle', 'education', 'pan', 'smell', 'friction', 'thought', 'crowd', 'creature', 'pets', 'cannon', 'relation', 'roll', 'library', 'interest', 'bells', 'milk', 'scissors', 'school', 'locket', 'steam', 'church', 'pump', 'zephyr', 'swim', 'harbor', 'flock', 'discussion', 'dog', 'hook', 'pollution', 'army', 'loss', 'children', 'spoon', 'base', 'wash', 'throat', 'cushion', 'selection', 'elbow', 'weather', 'instrument', 'day', 'pizzas', 'party', 'end', 'adjustment', 'wine', 'eggs', 'increase', 'vase', 'lamp', 'lumber', 'form', 'giraffe', 'pen', 'experience', 'hose', 'stick', 'authority', 'birth', 'insurance', 'boat', 'toe', 'aunt', 'laugh', 'person', 'calendar', 'art', 'silver', 'minute', 'string', 'office', 'twig', 'chickens', 'scent', 'oven', 'alarm', 'vest', 'bushes', 'pigs', 'plate', 'pail', 'crow', 'hat', 'breath', 'dad', 'statement', 'value', 'son', 'current', 'position', 'class', 'year', 'dogs', 'digestion', 'gold', 'tomatoes', 'waves', 'porter', 'bell', 'point', 'stew', 'nose', 'camera', 'scarecrow', 'kitty', 'food', 'mice', 'cows', 'glove', 'friend', 'pleasure', 'bag', 'birds', 'look', 'tooth', 'field', 'stitch', 'stretch', 'yarn', 'sponge', 'theory', 'babies', 'shame', 'iron', 'drain', 'start', 'system', 'flag', 'whistle', 'amount', 'shelf', 'wax', 'bone', 'texture', 'cellar', 'basin', 'sleep', 'morning', 'action', 'basket', 'robin', 'cherries', 'cap', 'caption', 'birthday', 'fang', 'jar', 'self', 'angle', 'tub', 'flower', 'weight', 'stomach', 'recess', 'eyes', 'lunch', 'wrist', 'lock', 'mine', 'rock', 'ticket', 'taste', 'fairies', 'prose', 'face', 'payment', 'dinosaurs', 'dinner', 'pig', 'cent', 'honey', 'deer', 'reading', 'view', 'house', 'line', 'regret', 'camp', 'mint', 'business', 'coat', 'apparel', 'price', 'order', 'mailbox', 'wheel', 'cart', 'receipt', 'bit', 'cow', 'wire', 'egg', 'scale', 'mist', 'letter', 'eggnog', 'quarter', 'baseball', 'touch', 'grandfather', 'twist', 'society', 'bomb', 'property', 'coil', 'wood', 'box', 'trouble', 'needle', 'cats', 'holiday', 'picture', 'quilt', 'queen', 'trail', 'skate', 'dime', 'drink', 'clam', 'belief', 'mask', 'ducks', 'potato', 'dress', 'rabbits', 'memory', 'hammer', 'aftermath', 'doctor', 'ocean', 'addition', 'market', 'lake', 'existence', 'island', 'thread', 'governor', 'advertisement', 'death', 'dock', 'throne', 'growth', 'salt', 'tendency', 'pie', 'hospital', 'dirt', 'writer', 'sleet', 'structure', 'root', 'rail', 'kittens', 'battle', 'liquid', 'limit', 'government', 'songs', 'tramp', 'creator', 'plastic', 'daughter', 'soup', 'sticks', 'example', 'collar', 'hands', 'things', 'quill', 'noise', 'talk', 'distribution', 'lettuce', 'eye', 'toad', 'jelly', 'toothpaste', 'pet', 'measure', 'car', 'offer', 'planes', 'girls', 'pull', 'motion', 'kick', 'earthquake', 'cough', 'ring', 'crate', 'railway', 'cream', 'head', 'hot', 'star', 'wind', 'boy', 'coal', 'cake', 'agreement', 'sun', 'record', 'rate', 'jail', 'maid', 'sea', 'horse', 'truck', 'cattle', 'arithmetic', 'argument', 'steel', 'crib', 'behavior', 'wave', 'control', 'cabbage', 'zoo', 'spade', 'wrench', 'kiss', 'cheese', 'ghost', 'tent', 'feeling', 'cub', 'money', 'treatment', 'sisters', 'achiever', 'bat', 'machine', 'gun', 'soap', 'grain', 'hall', 'doll', 'passenger', 'hydrant', 'hour', 'company', 'design', 'veil', 'side', 'horses', 'attack', 'ray', 'square', 'pest', 'tiger', 'appliance', 'tongue', 'team', 'knowledge', 'rest', 'story', 'mouth', 'snakes', 'thrill', 'science', 'vacation', 'ear', 'notebook', 'tail', 'boot', 'wound', 'summer', 'amusement', 'number', 'leg', 'grandmother', 'effect', 'connection', 'chalk', 'stem', 'unit', 'airplane', 'toy', 'desk', 'juice', 'middle', 'support', 'bikes', 'idea', 'paper', 'coast', 'word', 'bird', 'wall', 'border', 'stone', 'brake', 'woman', 'verse', 'thing', 'sky', 'basketball', 'calculator', 'cup', 'discovery', 'apparatus', 'credit');
 BEGIN
   DBMS_OUTPUT.PUT_LINE('Inserare 75000 de linii in tabela Authors...');
      FOR v_i in 1..75000 LOOP
    v_nume := lista_nume(TRUNC(DBMS_RANDOM.VALUE(0, LISTA_NUME.COUNT))+1);
     IF (DBMS_RANDOM.VALUE(0,100)<50) THEN
         v_prenume1 := lista_prenume_fete(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_fete.count))+1);
         LOOP
            v_prenume2 := lista_prenume_fete(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_fete.count))+1);
            exit when v_prenume1<>v_prenume2;
         END LOOP;
       ELSE
         v_prenume1 := lista_prenume_baieti(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_baieti.count))+1);
         LOOP
            v_prenume2 := lista_prenume_baieti(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_baieti.count))+1);
            exit when v_prenume1<>v_prenume2;
         END LOOP;
       END IF;

     IF (DBMS_RANDOM.VALUE(0,100)<60) THEN
        IF LENGTH(v_prenume1 || ' ' || v_prenume2) <= 20 THEN
          v_prenume := v_prenume1 || ' ' || v_prenume2;
        END IF;
        else
           v_prenume := v_prenume1;
      END IF;
      insert into Authors values(v_i, v_prenume, v_nume);
      end loop;
 DBMS_OUTPUT.PUT_LINE('Authors done...');
--
      DBMS_OUTPUT.PUT_LINE('Inserare linii in tabela Books...');
    for v_i in 1..100000 loop
      v_The := DBMS_RANDOM.VALUE(0,100);
      v_OrAndNothing := DBMS_RANDOM.VALUE(0,100);
      v_bookname := '';
      if (v_The < 50) then
      v_bookname := 'The ';
      end if;
      v_random_noun := lista_substantive(TRUNC(DBMS_RANDOM.VALUE(0,lista_substantive.count))+1);
      v_random_adjective := lista_adjective(TRUNC(DBMS_RANDOM.VALUE(0,lista_adjective.count))+1);
      v_bookname := v_bookname || v_random_adjective || ' ' || v_random_noun;

      if (v_OrAndNothing<33) then
       v_random_noun := lista_substantive(TRUNC(DBMS_RANDOM.VALUE(0,lista_substantive.count))+1);
      v_random_adjective := lista_adjective(TRUNC(DBMS_RANDOM.VALUE(0,lista_adjective.count))+1);
      v_bookname := v_bookname || ' or ' ||  v_random_adjective || ' ' || v_random_noun;
      end if;

      if (v_OrAndNothing > 66) then
         v_random_noun := lista_substantive(TRUNC(DBMS_RANDOM.VALUE(0,lista_substantive.count))+1);
        v_random_adjective := lista_adjective(TRUNC(DBMS_RANDOM.VALUE(0,lista_adjective.count))+1);
        v_bookname := v_bookname || ' and ' ||  v_random_adjective || ' ' || v_random_noun;
      end if;
      v_AuthorID := trunc(DBMS_RANDOM.VALUE(0,75000))+1;
      v_isbn := '978-3-16-' || v_i ||'-0';
      v_nrPages := trunc(DBMS_RANDOM.VALUE(0,4000))+1;
      v_price := round(DBMS_RANDOM.VALUE(0,500),2);
      v_rating := round(DBMS_RANDOM.VALUE(0,10),2);

      INSERT INTO Books VALUES(v_i, lower(v_bookname), v_AuthorID, v_isbn, v_nrPages, v_price, v_rating);
    end loop;
  DBMS_OUTPUT.PUT_LINE('Done with Books...');
  commit;
--
  DBMS_OUTPUT.PUT_LINE('Inserare genuri( 1 000 000) in tabela Genres...');
  for v_i in 1..100000 loop
    v_gen := lista_genuri(trunc(dbms_random.value(0, lista_genuri.COUNT))+1);
    INSERT INTO Genres VALUES(v_i, v_i, v_gen);
  end loop;
  commit;
  DBMS_OUTPUT.PUT_LINE('Done with Genres...');
--
  DBMS_OUTPUT.PUT_LINE('Inserare subgenuri(1 000 000) in tabela Subgenres...');
   for v_i in 1..100000 loop
    v_subgen := lista_subgenuri(trunc(dbms_random.value(0, lista_subgenuri.COUNT))+1);
    INSERT INTO SubGenres VALUES(v_i, v_i, v_subgen);
    if mod(v_i, 100000) = 0 then 
      commit;
    end if;
  end loop;
  
  DBMS_OUTPUT.PUT_LINE('Done with SubGenres...');
  commit;
--
 	DBMS_OUTPUT.PUT_LINE('Inserare 100 000 de linii in tabela Readers...');
 	FOR v_i in 1..100000 LOOP
    v_nume := lista_nume(TRUNC(DBMS_RANDOM.VALUE(0, LISTA_NUME.COUNT))+1);
     IF (DBMS_RANDOM.VALUE(0,100)<50) THEN
         v_prenume1 := lista_prenume_fete(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_fete.count))+1);
         LOOP
            v_prenume2 := lista_prenume_fete(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_fete.count))+1);
            exit when v_prenume1<>v_prenume2;
         END LOOP;
       ELSE
         v_prenume1 := lista_prenume_baieti(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_baieti.count))+1);
         LOOP
            v_prenume2 := lista_prenume_baieti(TRUNC(DBMS_RANDOM.VALUE(0,lista_prenume_baieti.count))+1);
            exit when v_prenume1<>v_prenume2;
         END LOOP;
       END IF;

     IF (DBMS_RANDOM.VALUE(0,100)<60) THEN
        IF LENGTH(v_prenume1 || ' ' || v_prenume2) <= 20 THEN
          v_prenume := v_prenume1 || ' ' || v_prenume2;
        END IF;
        else
           v_prenume := v_prenume1;
      END IF;
     v_data_nastere := TO_DATE('01-01-1974','MM-DD-YYYY')+TRUNC(DBMS_RANDOM.VALUE(0,7300));
     v_user := 'user' || v_i;
     v_password := 'password' || v_i;
    insert into Readers values(v_i, v_prenume, v_nume, v_user, v_password, v_data_nastere, 0);
  end loop;
    	DBMS_OUTPUT.PUT_LINE('Readers is done...');--


  commit;
    DBMS_OUTPUT.PUT_LINE('Inserare 1 000 000 linii in tabela ReadBooks. Si Concomitent Books Borrowed..');
    for v_i in 1..100000 loop
      v_readerID := TRUNC(DBMS_RANDOM.VALUE(0, 99998))+1;
      v_bookID := TRUNC(DBMS_RANDOM.VALUE(0, 99998))+1;
      v_loanDate := TO_DATE('01-01-2019','MM-DD-YYYY')+TRUNC(DBMS_RANDOM.VALUE(0,80));
      v_returnDate := v_loanDate + 14;
      v_score := TRUNC(DBMS_RANDOM.VALUE(1, 11));
      if v_score = 11 then 
        v_score := 10;
      end if;
      INSERT INTO ReadBooks values(v_i, v_readerID, v_bookID, v_score, lista_opinii(v_score));
      insert into BooksBorrowed values(v_i, v_readerID, v_bookID, v_loanDate, v_returnDate, 1, 1);
      if mod(v_i, 10000) = 0 then 
        commit;
      end if;
    end loop;
    DBMS_OUTPUT.PUT_LINE('Done with ReadBooks Si Concomitent Books Borrowed...');
    
  commit;
    
  
  DBMS_OUTPUT.PUT_LINE('Done with setting Books real rating...');
end;




/* ASTA APOI, DE AICI PANA UNDE SE TERMINA //**
  create index index_readbooks_booksid on readbooks(booksid);

update books b set b.RATING = nvl((
    select avg(rating) from ReadBooks r where 
    r.BooksID = b.ID
    group by r.BooksId
  ), b.rating);

 create index index_authors_afname on Authors(afname);
  create index index_authors_alname on Authors(alname);
  create index index_books_name on Books(name);
  create index index_books_authorid on Books(authorid);
  create index index_books_isbn on Books(isbn);
  create index index_books_nrpages on Books(nrpages);
  create index index_books_price on Books(price);
  create index index_books_rating on Books(rating);
  create index index_booksborrowed_readerid on booksborrowed(readerid);
  create index index_booksborrowed_bookid on booksborrowed(booksid);
  create index index_genres_booksid on genres(booksid);
  create index index_genres_gname on genres(gname);

  create index index_readbooks_readersid on readbooks(readersid);
  create index index_readbooks_rating on readbooks(rating);

  create index index_readers_username on readers(username);
  drop index index_readers_username;
  create index index_readers_totalfine on readers(totalfine);

  create index index_subgenres_booksid on subgenres(booksid);
  create index index_subgenres_gname on subgenres(sgname);


*/

/*de curatat daca e nevoie
DROP TABLE Books CASCADE CONSTRAINTS;
/
DROP TABLE Genres CASCADE CONSTRAINTS;
/
DROP TABLE SubGenres CASCADE CONSTRAINTS;
/
DROP TABLE Authors CASCADE CONSTRAINTS;
/
DROP TABLE Readers CASCADE CONSTRAINTS;
/
DROP TABLE ReadBooks CASCADE CONSTRAINTS;
/
drop TABLE BooksBorrowed;
/ 

CREATE TABLE Authors(
ID Int NOT NULL PRIMARY KEY,
AFName varchar(255) NOT NULL,
ALName varchar(255) NOT NULL
)
/

CREATE TABLE Books(
ID Int NOT NULL PRIMARY KEY,
Name varchar(255) NOT NULL,
AuthorID Int NOT NULL,
ISBN varchar(255) NOT NULL, --UNIQUE
nrPages Int NOT NULL,
Price Number(6,2) NOT NULL,
Rating Number(4,2) NOT NULL,
CONSTRAINT fk_Books_AuthorID FOREIGN KEY (AuthorID) REFERENCES Authors(ID)
)
/

CREATE TABLE Genres(
ID Int NOT NULL PRIMARY KEY,
BooksID Int NOT NULL,
Gname varchar(255) NOT NULL,
CONSTRAINT fk_Genres_BooksID FOREIGN KEY (BooksID) REFERENCES Books(ID)
)
/

CREATE TABLE SubGenres(
ID Int NOT NULL PRIMARY KEY,
BooksID Int NOT NULL,
SGname varchar(255) NOT NULL,
CONSTRAINT fk_SubGenres_BooksID FOREIGN KEY (BooksID) REFERENCES Books(ID)
)
/

CREATE TABLE Readers(
ID Int NOT NULL PRIMARY KEY,
Fname varchar(255) NOT NULL,
Lname varchar(255) NOT NULL,
Username varchar(255) NOT NULL,
Password varchar(255) NOT NULL,
BirthDate Date NOT NULL,
TotalFine Number(6,2)
)
/

CREATE TABLE ReadBooks(
ID Int NOT NULL PRIMARY KEY,
ReadersID Int NOT NULL,
BooksID Int NOT NULL,
Rating Number(2) NOT NULL,
Review varchar(2005),
CONSTRAINT fk_ReadBooks_ReadersID FOREIGN KEY (ReadersID) REFERENCES Readers(ID),
CONSTRAINT fk_ReadBooks_BooksID FOREIGN KEY (BooksID) REFERENCES Books(ID)
)
/

CREATE TABLE BooksBorrowed(
ID Int NOT NULL PRIMARY KEY,
ReaderID Int NOT NULL,
BooksID Int NOT NULL,
LoanDate date NOT NULL,
ReturnDate date NOT NULL,
IsReturned number(1, 0) NOT NULL,
IsFinePaid number(1, 0) not null,
CONSTRAINT fk_BooksBorrowed_ReaderID FOREIGN KEY (ReaderID) REFERENCES Readers(ID),
CONSTRAINT fk_BooksBorrowed_BooksID FOREIGN KEY (BooksID) REFERENCES Books(ID)
)
/

*/
/*

select * from Books;
select count(*) from books 
join authors on books.authorid = authors.id;
select * from BooksBorrowed;
select * from Genres order by id;
select * from SubGenres order by id;
select * from Authors order by id;
select * from ReadBooks;
select * from Readers;
*/
/*
ALTER TABLESPACE users
    ADD DATAFILE 'E:\AICI\usersGb2.dbf' SIZE 1000M
      AUTOEXTEND ON
      NEXT 512K
      MAXSIZE 2000M;
*/
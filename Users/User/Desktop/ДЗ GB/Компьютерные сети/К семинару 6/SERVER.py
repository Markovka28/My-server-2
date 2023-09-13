
import socket
import threading
import locale

# connecrion data
host = '5.172.21.208'   # переменная host будет ip адресом  
port = 55555            # открытая часть трубы. Можно представить как разъем

#Starting Server ТУТ МЫ СОЗДАЛИ SOCKET ОПИСАЛИ САМУ СТРУКТУРУ
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM) 
# у сокета есть метод socket в котором мы создаем socket типа AF_INET (класический интернет типа ipv4), 
# далее выбираем тип socket SOCK_STREAM это TCP типа потока данных DGRAM ЭТО UDP
server.bind((host, port))       # тут мы socket привязываем к хосту и к порту которые указаны в строках 6 и 7
server.listen                   # тут socket переведен в состояние листен

#Lists For Clients and Their Nicknames тут написан чат, куда будут подсоединяться клиенты с именами
clients = []                    # создаем массив клиентов и их ников
nicknames = []

#Senfing Messages To All Connected Clients
def broadcast(message):         # функция broadcast принимает на вход некий message
    for client in clients:      # и для каждого клиента в массиве клиентов
        client.send(message)    # мы будем рассылать это сообщение, в т.ч. и тому кто его послал
        
#Hading Messages From Clients
def handle(client): # в эту функцию ЗАПУСКАЕМ КАК ОТДЕЛЬНЫЙ ПОТОК В 61 СТР передается отдельный клиент который создался и отделился из строки 61
    while True:
        try:
            #Broadcasting Messages # эти строки позволяют обмениваться сообщениями и рождают сам чат
            message = client.recv(1024) # функция постоянно ждет с помощью функции recv(1024) какого то сообщения
            broadcast(message) # как только сообщение приходит оно рассылвается броадкастом
        except: # в этом блоке отрабатывается ошибка
            #Removing and Closing Clients
            index = clients.index(client) # тут мы из массива клиента узнаем его индекс
            clients.remove(client) # найденного клиента с ощибкой тут изымаем
            client.close() # закрываем сокет с ним
            nickname = nicknames[index] # достаем индекс ника
            broadcast('{} left!'.format(nickname).encode('ascii')) # пишем что такой то ник покинул чат
            nicknames.remove(nickname) # и тоже его удаляем
            break    
# Recieving / Lostening Function
def receive(): # функция бесконечная
    while True: # по сути это поток
        #Accept connection
        client, addres = server.accept() # данный поток который от сокета который мы создали вверху ожидает перехода в состояние accept()
        print('Connected with {}'.format(str(addres))) # после того как сервер переходит в состояние accept()пишем что к нам 
        # подсоединился какой то комп c определенным адресом str(addres) из этого сокета рождается клиент
        
        #Request and Store nickname
        client.send('NICK'.encode('ascii')) # это сокет клиент сюда мы посылаем сообщение скажи свой 'NICK' в формате аски - 'ascii' кода - это просто англ алфавит т.е. все что есть на клавиатуре кроме рус.яз
        nickname = client.recv(1024).decode('ascii') # тут строка его ник и тут мы принимаем сообщения в формате аски кода от нашего клиента
        nicknames.append(nickname)  # тут мы в массив nicknames который создавали вверху добавляем свой ник
        clients.append(client)      # тут мы в массив nicknames который создавали вверху добавляем клиент которые изъяты из строк 50-51
        
        #Print and Broadcast nickname
        print('Nickname is {}'.format(nickname))    # выводим сообщение что такой то ник к нам подключился
        broadcast('{} joined!'.format(nickname).encode('ascii')) # рассылаем факт подключения броадкастом
        client.send('Connected to server!'.encode('ascii')) # всех извещаем что такой то человек к нам подключился
        
        #Start Handing Thread For client
        thread = threading.Thread(target=handle, args=(client,)) 
        # тут создается отдельный поток в котором запускаем функцию handle этот поток отделяется 
        #  а while True продолжает ждать нового клиента
        thread.start()
        
print('Server if listening...') # cервер выводит сообщение: сервер слушает, и дальше начинается функция приема def receive():
receive() # исполнение данного кода начинается из этой строки т.к. все жо этого описание функцции
        
        



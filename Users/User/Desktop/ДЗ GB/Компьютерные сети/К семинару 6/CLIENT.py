import socket
import threading
import locale

#Choosing nick
nickname = input('Choose your nick: ') # предложение ввеси свой никнейм 

#Connecting to Server
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # создаем сокет называем его клиент в ipv4 пространстве(AF_INET), TCP(SOCK_STREAM)
client.connect(('91.200.151.138', 55555)) # тут мы сразу подсоединяемся и указываем ай пи сервера

#Listening to server and sending nick
def receive(): # функция на прием
    while True: # бесконечная функция
        try:
            #Recieve message from server
            # if 'nick' send nick
            message = client.recv(1024).decode('ascii') # ждем сообщения из клиентского сокета
            encoding = locale.getpreferredencoding(do_setlocale=True)
            # decode из принятых байтов достает аски код
            if message == 'NICK': # если message равен приглашению значит сервер все принял сокет установился
                client.send(nickname.encode('ascii')) # посылаем ник который создали в 5 строке
            else: # иначе если мы принимаем иное сообщение, не ник
                print(message) # то мы просто выводим его на экран
        except:
            #close connection when error
            print('An error occured!')
            client.close()
            break
        
def write(): # функция на передачу
    while True: # бесконечный цикл в потоке
        message = '{}: {}'.format(nickname, input(' ')) # подготавливается сообщение: ник и то что вобъем через : в input
        encoding = locale.getpreferredencoding(do_setlocale=True)
        client.send(message.encode('ascii')) # если нажали ентер сообщение подготавливается и с помощью функции send посылаем сообщение в наш клиентский сокет
        
#Starting threads for listening and writing
receive_thread = threading.Thread(target=receive) # тут запускаем функцию receive с помощью Thread в двух независимых потоках
receive_thread.start()

write_thread = threading.Thread(target=write) # тут запускаем функцию write
write_thread.start()
import socket

def Main():
    print("Send 'q' to exit\n")
    address = str(input("ip:port -> "))
    nick = input("nick: ")

    try:
        if address.index(":") != 0:
            host = address[:address.index(":")]
            port = int(address[address.index(":")+1:])
    except ValueError:
        host = '5.172.21.208'
        port = 5000

    s = socket.socket()
    s.connect((host, port))

    message = input("-> ")

    while message != "q":
        s.send(bytes(message + "ยง" + nick, "UTF-8"))
        data = s.recv(1024)
        data = data.decode("UTF-8")
        data2 = data

        messageServer = str(data[:data.index("ยง")])
        nickServer = str(data[data.index("ยง")+1:])
        if not data == data2:
            print(nickServer + ": " + messageServer)
        message = input("-> ")
    s.close()

if __name__ == "__main__":
    Main()
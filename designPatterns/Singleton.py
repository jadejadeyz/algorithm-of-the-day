import threading


class Singleton(type):

    def __init__(cls, name, bases, attrs, **kwargs):
        super().__init__(name, bases, attrs)
        cls._instance = None
        cls.lock = threading.Lock()

    def __call__(cls, *args, **kwargs):
        if cls._instance is None:
            with cls.lock:
                if cls._instance is None:
                    cls._instance = super().__call__(*args, **kwargs)
        return cls._instance


class Test(metaclass=Singleton):
    def __init__(self):
        print('a')



t1 = Test()
t2 = Test()

print(t1)
print(t2)
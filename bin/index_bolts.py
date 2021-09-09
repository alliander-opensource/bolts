import os
import sys
from string import Template


class Indexer:
    def __init__(self, formatter):
        self.formatter = formatter

    def index(self, directory, writer):
        dirs = [f for f in os.listdir(directory) if os.path.isdir(os.path.join(directory, f))]
        dirs.sort()
        writer.write(self.formatter.format(dirs))


class Formatter:
    def __init__(self, main_path, bolts_path, bolt_path):
        self.main = Template(open(main_path).read())
        self.bolts = Template(open(bolts_path).read())
        self.bolt = Template(open(bolt_path).read())

    def format(self, dirs):
        single = ''.join([self.bolt.safe_substitute(bolt=dir) for dir in dirs])
        bolts = self.bolts.safe_substitute(bolts=single)
        return self.main.safe_substitute(bolts=bolts)


if __name__ == '__main__':
    formatter = Formatter('bin/template/main.html',
                          'bin/template/bolts.html',
                          'bin/template/bolt.html')
    indexer = Indexer(formatter)

    writer = open('docs/index.html', 'w')
    indexer.index('docs', writer)

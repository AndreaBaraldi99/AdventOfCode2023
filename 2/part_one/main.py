import re

sum = 0

def checkvalidGame(dict):
    valid = True       
    for x, y in dict.items():
        if x == 'red':
            if y > 12:
                valid = False
        if x == 'green':
            if y > 13:
                valid = False
        if x == 'blue':
            if y > 14:
                valid = False
    return valid

with open('2\part_one\input.txt', 'r') as input_file:
    for item in input_file:
        valid = True
        reg = re.search(r'\w+\s(\d+):\s(.+)*', item, re.M)
        game_num = reg.group(1)
        games_list = reg.group(2).split(';')
        for game in games_list:
            gameCube = re.findall(r'\s*(\d+)\s(\w+)', game)
            color_num_list = [(y, int(x)) for (x,y) in gameCube]
            game_dict = dict(color_num_list)
            if not checkvalidGame(game_dict):
                valid = False
        if valid:
            sum += int(game_num)

print(sum)           


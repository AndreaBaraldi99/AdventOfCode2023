import re

sum = 0

with open('2\part_two\input.txt', 'r') as input_file:
    for item in input_file:
        power = 1
        set_dict={"red" : 1, "green" : 1, "blue" : 1}
        valid = True
        reg = re.search(r'\w+\s(\d+):\s(.+)*', item, re.M)
        game_num = reg.group(1)
        games_list = reg.group(2).split(';')
        for game in games_list:
            gameCube = re.findall(r'\s*(\d+)\s(\w+)', game)
            color_num_list = [(y, int(x)) for (x,y) in gameCube]
            game_dict = dict(color_num_list)
            for x,y in game_dict.items():
                if set_dict[x] < y:
                    set_dict[x] = y
        for x,y in set_dict.items():
            power *= y
        sum += power
print(sum)     
import urllib2
import bs4
import os
import random

def getRecipeData(ID, holdRecipe = False):
    baseURL = "http://www.therecipedepository.com/recipe/"
    fileNameBase = "Recipe"
    
    url = baseURL + str(ID)
    urlReq = urllib2.urlopen(url)
    html = urlReq.read()
    
    if holdRecipe is True:
        fileNameBase += "ID" + str(ID)
        
    fileWithHTML = open(fileNameBase + ".html", 'w')
    soup = bs4.BeautifulSoup(html)
    lineNo = 0
    for line in soup.prettify():
        fileWithHTML.write(line)
    fileWithHTML.close()
    
    return "Done.  File has been created in local dir."

def formatTextFile(ID):
    fileWithHTML = open('RecipeID'+str(ID)+'.html', 'r')
    fileWithTXT = open('RecipeID'+str(ID)+'.txt', 'w')
    L = [".", ",", "cup", "of", "Tbsp", "tsp", ")"]
    flag = False
    for line in fileWithHTML:
        if "Recipe Reviews" in line:
            break
        if flag is True:
            if "{" not in line and '<' not in line and '>' not in line:
                fileWithTXT.write((line).strip()+'\n')
                if "Rating" in line: 
                    fileWithTXT.write(str(random.randint(0, 5))+'\n')
        if "Frequently Asked Questions" in line: 
            flag = True
    fileWithTXT.write("***************\n")
    fileWithTXT.close()
    fileWithHTML.close()
    return "Done creating text file."

def getMuchData(lowerID, higherID, holdRecipe = False):
    failures = 0
    successes = 0
    for i in range(lowerID, higherID):
        try: 
            getRecipeData(i, holdRecipe)
            formatTextFile(i)
            successes+=1
        except: 
            failures+=1

    filenames = ['RecipeID'+str(i)+'.txt' for i in range(lowerID, higherID)]
    with open('MasterRecipeList.txt', 'w') as outfile:
        for fname in filenames:
            if os.path.isfile(fname):
                with open(fname) as infile:
                    for line in infile:
                        outfile.write(line)
    print("Done.  "+str(successes)+" recipes imported.  "+str(failures)+" recipe(s) failed to import.")
    return "Done."


#100 - 178
#200 - 558

getMuchData(100, 1133, True)
# getRecipeData(100, True)
# formatTextFile(100)
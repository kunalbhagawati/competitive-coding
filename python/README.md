# Solutions for competitive coding questions in Python

## Folder structure
```
├── src/  # all solutions here must be in this programming language.
│  ├── <website-slug-identifier>  # folder-wise grouping of the website of the question attempted.
│  │  ├── <question-as-subfolders>  # Folder structure that represents the question. The nesting here should represent the question and it's grouping clearly. e.g. https://adventofcode.com/ groups questions by year and day. So we group it as `/y2015/day1`. Should also contain a reference to the question, either as docstring in the solution, or using other files here.
│  │  │  ├── __init__.py  # (Optional). Marks the folder as a python package.
│  │  │  ├── ./solution.py  # Solution file.
│
├── other language specific files.
├── README.md
```

## About The Project

This is a personal project I made to practice my java skills before my semester started. I always loved data and I live by data, so I wanted to do a project with data. When thinking to myself on what data is more available and used, I thought of finance. I ended up doing bitcoin to track because its 24/7 and live data is easier to get than stocks.

Here is my logic for the program just for a basis of understanding

* Scrape this website every minute [https://bitcointicker.co/coinbase/btc/usd/10m/](https://bitcointicker.co/coinbase/btc/usd/10m/) for live data
* organize the data and write it to a new line on a csv file
* upload the data using a python script every 24 hours at 12:00 am


## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

- **Java 23** (for running the project)
- **Python 3** (for the upload script)
- **Maven** (for building the project)
- **Kaggle API Key** (for uploading data to Kaggle)

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a Kaggle json by following the section under "Authentication" [kaggle.com/docs/api](https://www.kaggle.com/docs/api)
2. Install maven on windows or linux
3. put the json in the locations for windows and linux respectfully 
    * C:\Users\username\.kaggle\
    * ~/.kaggle/
4. Install requirements.txt
   ```sh
   pip install -r requirements.txt
   ```
5. edit the json at dataPipelineProject/src/main/csv_files/dataset-metadata.json

6. cd to the project location and build the maven project
   ```sh
   mvn clean package
   ```
7. Run the .jar file located in the target folder created in the project folder to begin data collection
8. Run the python file or automate it to upload the data to kaggle



<!-- USAGE EXAMPLES -->
## Usage

This project is used to scrape bitcoin data and upload it to Kaggle every day. I personally run it on a raspberry pi 5
running ubuntu linux, and it works very well. If you want you can also easily edit the code to run with any website and data
you want. I didn't design it for changing so sorry for any troubles that come along the way with that. You can see the Kaggle
Below

[kaggle.com/datasets/erikhox/bitcoin-minute-data/data](https://www.kaggle.com/datasets/erikhox/bitcoin-minute-data/data)


<!-- CONTRIBUTING -->
## Contributing

An anything open source is, It is open to contributions if you see any way to make the project better!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the Unlicense License. See `LICENSE.txt` for more information.

## Contact

Erik Hoxhaj: [linkedin](https://www.linkedin.com/in/erikhoxhaj/) - [personal website](https://www.erikhoxhaj.com/) - erik.hoxhaj@outlook.com

Project Link: [github.com/erikhox/dataPipelineProject](https://github.com/erikhox/dataPipelineProject/)

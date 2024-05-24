import express from "express";
import { homeController } from "./controllers/indexController.js";

const port = process.env.PORT || 3000;
const app = express()

app.use(homeController)

process.on("SIGTERM", () => {
    console.log("SIGTERM received, exiting application with exit(0)");
    process.exit(0);
});

process.on("SIGINT", () => {
    console.log("SIGINT received, exiting application with exit(0)");
    process.exit(0);
});

app.listen(port, () => {
    console.log(`Server listening on port ${port}`)
})




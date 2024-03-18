import { Link } from "@nextui-org/react";
import React from "react";

export const Categories = () => {
  return (
    <div className="mt-10">
      <h1 className="text-2xl text-center underline">Our Products</h1>
      <div className="grid grid-cols-2 gap-5 mt-5 md:grid md:grid-cols-3">
        <Link
          href="/selection"
          className="flex flex-col items-center border rounded-md border-neutral-500 w-48 shadow-md"
        >
          <img
            className="h-52 rounded-md"
            src="https://m.media-amazon.com/images/I/51PeivonywL.jpg"
          ></img>
          <p>Guitars</p>
        </Link>
        <Link
          href="/products/tuners"
          className="flex flex-col items-center border border-neutral-500 w-48 shadow-md rounded-md"
        >
          <img
            className="h-52 rounded-md"
            src="https://m.media-amazon.com/images/I/41duhgZ9KgL._AC_.jpg"
          ></img>
          <p>Tuners</p>
        </Link>
        <Link
          href="/products/amplifiers"
          className="flex flex-col items-center border rounded-md border-neutral-500 w-48 shadow-md"
        >
          <img
            className="h-52 rounded-md"
            src="https://m.media-amazon.com/images/I/A1BIKnpDo2L.jpg"
          ></img>
          <p>Amplifiers</p>
        </Link>
        <Link
          href="/products/pickups"
          className="flex flex-col items-center rounded-md border border-neutral-500 w-48 shadow-md"
        >
          <img
            className="h-52 rounded-md"
            src="https://m.media-amazon.com/images/I/61ePeaLI8EL.jpg"
          ></img>
          <p>Pickups</p>
        </Link>
        <Link
          href="/products/picks"
          className="flex flex-col items-center rounded-md border border-neutral-500 w-48 shadow-md"
        >
          <img
            className="h-52 rounded-md"
            src="https://m.media-amazon.com/images/I/81qUghPO9AL.jpg"
          ></img>
          <p>Picks</p>
        </Link>
      </div>
    </div>
  );
};

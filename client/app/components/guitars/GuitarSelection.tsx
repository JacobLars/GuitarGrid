import { Link } from "@nextui-org/react";
import React, { useState } from "react";

export const GuitarSelection = () => {
  const [selected, setSelected] = useState<String>("");

  const handleElectricClick = () => {
    setSelected("electric");
  };
  const handleAcousticClikc = () => {
    setSelected("acoustic");
  };

  return (
    <div>
      <div className="flex flex-col h-10 items-center">
        <Link
          href="/guitars/electric"
          className="flex flex-col items-center border border-neutral-500 m-5 w-52 shadow-md"
        >
          <img
            className="h-52"
            src="https://m.media-amazon.com/images/I/51PeivonywL.jpg"
          ></img>
          <p>Electric</p>
        </Link>
        <Link
          href="/guitars/acoustic"
          className="flex flex-col items-center border border-neutral-500 m-5 w-52 shadow-md"
        >
          <img
            className="h-52"
            src="https://m.media-amazon.com/images/I/61Reg6GU9pL.jpg"
          ></img>
          <p>Acoustic</p>
        </Link>
      </div>
    </div>
  );
};

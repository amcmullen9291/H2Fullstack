import { useState, useEffect } from "react";

const delay = 5;

export default function SelectedCheese() {
  const [show, setShow] = useState(false);

  useEffect(
    () => {
      let timer1 = setTimeout(() => setShow(true), delay * 1000);

      // this will clear Timeout
      // when component unmount like in willComponentUnmount
      // and show will not change to true
      return () => {
        clearTimeout(timer1);
      };
    },
    // useEffect will run only one time with empty []
    // if you pass a value to array,
    // like this - [data]
    // than clearTimeout will run every time
    // this value changes (useEffect re-run)
    []
  );

  return show ? (
    <div>show is true, {delay}seconds passed</div>
  ) : (
    <div>show is false, wait {delay}seconds</div>
  );
}